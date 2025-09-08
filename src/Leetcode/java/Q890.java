package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q890 {
    class Solution {
        String pattern;
        int n;
        Set<Integer>[] pat;
        public boolean doesMatch(String word) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> visited = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                char oriChar = pattern.charAt(i);
                if (map.containsKey(c)) {
                    char mapChar = map.get(c);
                    sb.append(mapChar);
                } else {
                    if (visited.contains(oriChar)) return false;
                    visited.add(oriChar);
                    map.put(c, oriChar);
                    sb.append(oriChar);
                }
            }
            return pattern.equals(sb.toString());
        }

        public List<String> findAndReplacePattern(String[] words, String pattern) {
            this.pattern = pattern;
            n = pattern.length();
            pat = new HashSet[26];
            for (int i=0; i<26; i++) pat[i] = new HashSet<>();
            for (int i=0; i<n; i++) pat[pattern.charAt(i)-'a'].add(i);

            List<String> ans = new ArrayList<>();
            for (String word: words) {
                if (doesMatch(word)) ans.add(word);
            }
            return ans;
        }
    }
}
