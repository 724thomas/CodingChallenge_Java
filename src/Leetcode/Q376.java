package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][2]; // length, up/down
            dp[0] = new int[]{1,1};

            for (int i=1; i<n; i++) {
                int prev = nums[i-1], curr = nums[i];
                if (prev < curr) { //up
                    dp[i][0] = dp[i-1][1] + 1;
                    dp[i][1] = dp[i-1][1];
                } else if (prev > curr) {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][0] + 1;
                } else {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                }
            }

            return Math.max(dp[n-1][0], dp[n-1][1]);
        }
    }
}
