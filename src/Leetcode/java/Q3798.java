package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3798 {
    class Solution {
        public String largestEven(String s) {
            int n = s.length();
            int idx = n;
            for (int i=n-1; i>=0; i--) {
                if (s.charAt(i) == '2') break;
                n = i;
            }
            return s.substring(0, n);
        }
    }
}
