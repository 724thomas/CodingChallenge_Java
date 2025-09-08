package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2481 {
    class Solution {
        public int numberOfCuts(int n) {
            if (n==1) return 0;
            if (n%2 == 0) return n/2;
            return n;
        }
    }
}
