package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.LinkedHashMap;

public class Q3039 {
    class Solution {
        public String lastNonEmptyString(String s) {
            LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
            int cmax = 0;

            for (char c : s.toCharArray()) {
                int count = lhm.getOrDefault(c, 0);
                lhm.remove(c);
                lhm.put(c, count+1);
                cmax = Math.max(cmax, count+1);
            }

            StringBuilder sb = new StringBuilder();
            for (var entry : lhm.entrySet()) {
                if (entry.getValue() == cmax) {
                    sb.append(entry.getKey());
                }
            }


            return sb.toString();
        }
    }
}
