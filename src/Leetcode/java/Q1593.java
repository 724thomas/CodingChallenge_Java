package Leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class Q1593 {
    class Solution {
        public int dfs(Set<String> visited, String s, int idx, int count) {
            if (idx >= s.length()) return count;
            StringBuilder substring = new StringBuilder();
            int cmax = 0;
            for (int i = idx; i<s.length(); i++) {
                substring.append(s.charAt(i));
                if (visited.contains(substring.toString())) continue;

                visited.add(substring.toString());

                cmax = Math.max(cmax, dfs(visited, s, i+1, count+1));

                visited.remove(substring.toString());
            }

            return cmax;
        }

        public int maxUniqueSplit(String s) {
            return dfs(new HashSet<>(), s, 0, 0);
        }
    }
}
