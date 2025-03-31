package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3438 {
    class Solution {
        public String findValidPair(String s) {
            int n = s.length();
            Map<Character, Integer> counter = new HashMap<>();
            for (char c:s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c,0)+1);
            }

            for (int i=0; i<n-1; i++) {
                if (s.charAt(i) != s.charAt(i+1) &&
                        counter.get(s.charAt(i)) == s.charAt(i) - '0' &&
                        counter.get(s.charAt(i+1)) == s.charAt(i+1) - '0') {
                    return s.substring(i,i+2);
                }
            }

            return "";
        }
    }
}
