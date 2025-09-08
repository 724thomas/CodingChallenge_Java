package Leetcode.java;

import java.util.Arrays;

public class Q1790 {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) return true;
            char[] s1char = s1.toCharArray(), s2char = s2.toCharArray();
            Arrays.sort(s1char);
            Arrays.sort(s2char);

            int count = 0;
            for (int i = 0; i<s1.length(); i++) {
                if (s1char[i] != s2char[i]) return false;
                if (s1.charAt(i) != s2.charAt(i)) count++;
                if (count>2) return false;
            }
            return count%2 == 0;
        }
    }
}
