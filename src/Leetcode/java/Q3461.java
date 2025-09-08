package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3461 {
    class Solution {
        public String calc(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n-1; i++) {
                int left = Integer.parseInt(s.charAt(i)+"");
                int right = Integer.parseInt(s.charAt(i+1)+"");
                sb.append( (left+right) % 10);
            }
            return sb.toString();
        }
        public boolean hasSameDigits(String s) {
            while (s.length() > 2) s = calc(s);
            return s.charAt(0) == s.charAt(1);
        }
    }
}
