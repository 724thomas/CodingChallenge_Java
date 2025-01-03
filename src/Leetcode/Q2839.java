package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2839 {
    class Solution {
        public boolean canBeEqual(String s1, String s2) {
            Map<Character, Integer> counterEven = new HashMap<>();
            Map<Character, Integer> counterOdd = new HashMap<>();

            for (int i=0; i<s1.length(); i++) {
                char c = s1.charAt(i);
                if (i%2==0) {
                    counterEven.put(c, counterEven.getOrDefault(c,0)+1);
                } else {
                    counterOdd.put(c, counterOdd.getOrDefault(c,0)+1);
                }
            }

            for (int i=0; i<s1.length(); i++) {
                char c = s2.charAt(i);
                if (i%2 == 0) {
                    counterEven.put(c, counterEven.getOrDefault(c, 0) -1);
                    if (counterEven.get(c) == -1) return false;
                } else {
                    counterOdd.put(c, counterOdd.getOrDefault(c, 0)-1);
                    if (counterOdd.get(c) == -1) return false;
                }
            }
            return true;
        }
    }
}
