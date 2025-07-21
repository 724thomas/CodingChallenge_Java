package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3469 {
    class Solution {
        int[] nums;
        int n;
        Integer[][] dp;
        public int dfs(int prev, int pos) {
            if (pos == n) return nums[prev];
            if (pos == n-1) return Math.max(nums[prev], nums[pos]);
            if (dp[prev][pos] != null) return dp[prev][pos];

            int curr0 = Math.max(nums[prev], nums[pos]) + dfs(pos+1, pos+2);
            int curr1 = Math.max(nums[pos], nums[pos+1]) + dfs(prev, pos+2);
            int curr2 = Math.max(nums[prev], nums[pos+1]) + dfs(pos, pos+2);

            dp[prev][pos] = Math.min(curr0, Math.min(curr1, curr2));
            return dp[prev][pos];
        }

        public int minCost(int[] nums) {
            this.nums = nums;
            n = nums.length;
            dp = new Integer[n][n];

            if (n==1) return nums[0];
            if (n==2) return Math.min(nums[0], nums[1]);

            int curr0 = Math.max(nums[0], nums[1]) + dfs(2, 3);
            int curr1 = Math.max(nums[1], nums[2]) + dfs(0, 3);
            int curr2 = Math.max(nums[2], nums[0]) + dfs(1, 3);

            return Math.min(curr0, Math.min(curr1, curr2));


        /*
        작은 숫자가 남는게 유리.
        [1, 20, 7, 8, 18]
        [0][0] = 7, 20
        [0][1] = 1, 20
        [0][2] = 20, 7
        [1][0] = 18, 20+8 / 18, 20+8 / 18, 7 + 20 = 18, 27
        [1][1] = 7, 20 + 18 / 1, 20 + 18 / 20, 7 + 18 = 20, 25
        [1][2] = 8, 20 + 18 / 8, 20 + 18 / 8, 7 + 20 = 8, 27
        */
        }
    }
}
