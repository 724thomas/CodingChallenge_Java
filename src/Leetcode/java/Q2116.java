package Leetcode.java;

public class Q2116 {
    class Solution {
        public boolean canBeValid(String s, String locked) {
            int n = s.length();
            if (n % 2 == 1) return false;

            int val1 = 0, val2 = 0;
            for (int i=0; i<n; i++) {
                if (locked.charAt(i) == '1') {
                    val1 = (s.charAt(i) == '(') ? val1+1 : val1-1;
                } else {
                    val1++;
                }

                if (locked.charAt(n-1-i) == '1') {
                    val2 = (s.charAt(n-1-i) == ')') ? val2+1 : val2-1;
                } else {
                    val2++;
                }

                if (val1<0 || val2<0) return false;
            }
            return true;
        }
    }
}
