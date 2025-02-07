package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2485 {
    class Solution {
        public int pivotInteger(int n) {
            int[] lprefix = new int[n];
            int[] rprefix = new int[n];

            int lSum = 0, rSum = 0;
            for (int i=0; i<n; i++) {
                lSum += i+1;
                lprefix[i] = lSum;

                rSum += n-i;
                rprefix[n-i-1] = rSum;
            }

            for (int i=0; i<n; i++) {
                if (lprefix[i] == rprefix[i]) return i+1;
            }
            return -1;
        }
    }
}
