package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q3365 {
    class Solution {
        public boolean isPossibleToRearrange(String s, String t, int k) {
            int splitLength = s.length()/k;
            Map<String, Integer> sCounter = new HashMap<>();
            Map<String, Integer> tCounter = new HashMap<>();

            for (int i=0; i<k; i++) {
                String s1=s.substring(i*splitLength, i*splitLength + splitLength);
                sCounter.put(s1, sCounter.getOrDefault(s1, 0) +1);
                String s2=t.substring(i*splitLength, i*splitLength + splitLength);
                tCounter.put(s2, tCounter.getOrDefault(s2, 0) +1);
            }

            return sCounter.equals(tCounter);
        }
    }
}
