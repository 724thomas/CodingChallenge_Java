package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :

 */

public class Q5 {
    class Solution {
        int n;
        String ans = "";
        public String longestPalindrome(String s) {
            n = s.length();

            for (int i=0; i<n; i++) {
                getLength(s, i, i);
            }
            for (int i=0; i<n-1; i++) {
                getLength(s, i, i+1);
            }
            return ans;
        }

        public void getLength(String s, int left, int right) {
            String candid = "";

            while (left >= 0 && right < n && s.charAt(left)==s.charAt(right)) {
                candid = s.substring(left, right+1);
                left--;
                right++;
            }

            if (candid.length() > ans.length()) {
                ans = candid;
            }
        }
    }
}
