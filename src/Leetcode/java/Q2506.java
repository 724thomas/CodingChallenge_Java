package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2506 {
    class Solution {
        Map<String, Integer> counter = new HashMap<>();
        public int similarPairs(String[] words) {
            for (String word : words) {
                getDistinctChars(word);
            }

            int ans = 0;
            for (var entry : counter.entrySet()) {
                int count = entry.getValue();
                ans += count * (count-1) / 2;
            }
            return ans;
        }

        public void getDistinctChars(String word) {
            boolean[] visited = new boolean[26];
            for (char c : word.toCharArray()) {
                visited[c-'a'] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++) {
                if (visited[i]) sb.append((char)(i+'a'));
            }
            counter.put(sb.toString(), counter.getOrDefault(sb.toString(), 0) + 1);
        }
    }
}
