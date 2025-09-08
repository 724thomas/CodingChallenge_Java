package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3584 {
    class Solution {
        public long maximumProduct(int[] nums, int m) {
            int n = nums.length;
            long[][] left = new long[n][2];
            long[][] right = new long[n][2];

            left[0] = new long[]{nums[0], nums[0]};
            right[n-1] = new long[]{nums[n-1], nums[n-1]};
            for (int i=1; i<n; i++) {
                left[i][0] = Math.min(left[i-1][0], nums[i]);
                left[i][1] = Math.max(left[i-1][1], nums[i]);
                right[n-1-i][0] = Math.min(right[n-i][0], nums[n-1-i]);
                right[n-1-i][1] = Math.max(right[n-i][1], nums[n-1-i]);
            }

            long ans = Long.MIN_VALUE;

            for (int i=0; i<n-m+1; i++) {
                ans = Math.max(ans, left[i][0] * right[i+m-1][0]);
                ans = Math.max(ans, left[i][0] * right[i+m-1][1]);
                ans = Math.max(ans, left[i][1] * right[i+m-1][0]);
                ans = Math.max(ans, left[i][1] * right[i+m-1][1]);
            }

            return ans;
        }
    }
}
