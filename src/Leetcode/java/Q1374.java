package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q1374 {
    class Solution {
        public String generateTheString(int n) {
            char[] ans = new char[n];
            Arrays.fill(ans,'a');
            if (n % 2 == 0) ans[n - 1] = 'b';
            return String.valueOf(ans);
        }
    }
}
