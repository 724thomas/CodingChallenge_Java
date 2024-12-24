package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q1805 {
    class Solution {
        public String toInteger(String s) {
            StringBuilder sb = new StringBuilder();
            boolean isZero = true;
            for (Character c : s.toCharArray()) {
                if (c == '0' && isZero) continue;
                sb.append(c);
                isZero=false;
            }
            return sb.toString();
        }


        public int numDifferentIntegers(String word) {
            Set<String> nums = new HashSet<>();

            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    if (sb.length() != 0) nums.add(toInteger(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            if (sb.length()!=0) nums.add(toInteger(sb.toString()));
            return nums.size();
        }
    }
}
