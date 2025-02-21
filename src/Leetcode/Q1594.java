package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1594 {
    class Solution {
        public int maxProductPath(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int MOD = 1_000_000_007;
            long[][][] dp =  new long[n][m][2];
            dp[0][0] = new long[]{grid[0][0], grid[0][0]};

            for (int i=1; i<n; i++) {
                long val = dp[i-1][0][0] * grid[i][0];
                dp[i][0] = new long[]{val, val};
            }

            for (int i=1; i<m; i++) {
                long val = dp[0][i-1][0] * grid[0][i];
                dp[0][i] = new long[]{val, val};
            }

            for (int i=1; i<n; i++) for (int j=1; j<m; j++) {
                long topMin = dp[i-1][j][0] * grid[i][j];
                long topMax = dp[i-1][j][1] * grid[i][j];
                long leftMin = dp[i][j-1][0] * grid[i][j];
                long leftMax = dp[i][j-1][1] * grid[i][j];

                dp[i][j][0] = Math.min(topMin, Math.min(topMax, Math.min(leftMin, leftMax)));
                dp[i][j][1] = Math.max(topMin, Math.max(topMax, Math.max(leftMin, leftMax)));
            }

            long ans = dp[n-1][m-1][1];
            return ans < 0 ? -1: (int) (ans % MOD);
        }
    }
}
