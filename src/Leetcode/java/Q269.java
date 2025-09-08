package Leetcode.java;

import java.util.*;

public class Q269 {
    class Solution {
        Map<Character, Set<Character>> adj = new HashMap<>();
        int[] visited = new int[26]; // 0 = not visited, 1 = visiting, 2 = visited
        List<Character> ans = new ArrayList<>();

        public boolean dfs(Character c) {
            if (visited[c - 'a'] == 1) return true; // cycke
            if (visited[c - 'a'] == 2) return false;

            visited[c - 'a'] = 1;
            for (Character neighbor : adj.get(c)) {
                if (dfs(neighbor)) return true; // cycle
            }
            visited[c - 'a'] = 2;
            ans.add(c);
            return false;
        }

        public String alienOrder(String[] words) {
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    adj.putIfAbsent(c, new HashSet<>());
                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i], w2 = words[i + 1];
                int minLen = Math.min(w1.length(), w2.length());
                if (w1.length() > w2.length() &&
                        w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                    return "";
                } // check [..., "za" , "z", ...]

                for (int j = 0; j < minLen; j++) {
                    if (w1.charAt(j) != w2.charAt(j)) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        break;
                    }
                }
            }

            for (Character c : adj.keySet()) {
                if (visited[c - 'a'] == 0 && dfs(c)) return ""; // cycle
            }

            StringBuilder sb = new StringBuilder();
            for (int i = ans.size() - 1; i >= 0; i--) {
                sb.append(ans.get(i));
            }
            return sb.toString();
        }
    }

}
