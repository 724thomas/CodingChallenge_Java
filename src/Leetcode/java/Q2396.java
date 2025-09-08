package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2396 {
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length()-1;
            while (left<right) {
                if (s.charAt(left++) != s.charAt(right--)) return false;
            }
            return true;
        }

        public String toNBase(int n, int base) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int remain = n % base;
                sb.append(remain);
                n = n / base;
            }
            return sb.reverse().toString();
        }

        public boolean isStrictlyPalindromic(int n) {
            for (int i=2; i<=n-2; i++) {
                if (!isPalindrome( toNBase(n, i) )) return false;
            }
            return true;
        }
    }
}
