package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1297 {
    class Solution {
        public boolean check(String key, int maxLetters) {
            Set<Character> distincts = new HashSet<>();
            for (char c : key.toCharArray()) {
                distincts.add(c);
                if (distincts.size() > maxLetters) return false;
            }
            return true;
        }
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            int n = s.length();
            Map<String, Integer> counter = new HashMap<>();

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<minSize; i++) {
                sb.append(s.charAt(i));
            }
            counter.put(sb.toString(), counter.getOrDefault(sb.toString(), 0)+1);

            for (int i=minSize; i<n; i++) {
                sb.append(s.charAt(i));
                sb.delete(0, 1);
                counter.put(sb.toString(), counter.getOrDefault(sb.toString(), 0)+1);
            }

            int ans = 0;
            for (var entry : counter.entrySet()) {
                if (check(entry.getKey(), maxLetters)) {
                    ans = Math.max(ans, entry.getValue());
                }
            }
            return ans;
        }
    }
}
