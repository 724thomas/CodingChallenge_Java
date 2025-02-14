package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q396 {
    class Solution {
        public int maxRotateFunction(int[] nums) {
        /*
        F(0) = 0 * nums[0] + 1 * nums[1] + 2 * nums[2];
        F(1) = 2 * nums[2] + 0 * nums[1] + 1 * nums[2];
        F(0) - F(1) = nums[1] + nums[2] - (2*nums[2])
        */

            int n = nums.length;
            int total = 0;
            int f = 0;
            for (int i=0; i<nums.length; i++) {
                total += nums[i];
                f += i * nums[i];
            }

            int ans = f;
            for (int k = 1; k<n; k++) {
                int last = nums[n-k];

                f = f + total - n*last;
                ans = Math.max(ans, f);
            }
            return ans;
        }
    }
}
