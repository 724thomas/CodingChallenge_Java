package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q3424 {
    class Solution {
        public long minCost(int[] arr, int[] brr, long k) {
            int n = arr.length;
            long ans1 = 0;
            for (int i=0; i<n; i++) {
                ans1 += Math.abs(arr[i] - brr[i]);
            }

            Arrays.sort(arr);
            Arrays.sort(brr);

            long ans2 = k;
            for (int i=0; i<n; i++) {
                ans2 += Math.abs(arr[i] - brr[i]);
            }

            return Math.min(ans1, ans2);
        }
    }
}
