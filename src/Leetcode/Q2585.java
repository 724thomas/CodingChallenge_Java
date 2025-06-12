package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2585 {
    class Solution {
        int MOD = 1_000_000_007;
        public int waysToReachTarget(int target, int[][] types) {
            int n = types.length;
            int[][] dp = new int[n+1][target+1];
            dp[0][0] = 1;

            for (int i=0; i<n; i++) {
                int count = types[i][0], points = types[i][1];

                for (int j=0; j<= target; j++) {
                    dp[i+1][j] = dp[i][j]; // not add

                    for (int k = 1; k<= count; k++) { // add 1 upto total counts
                        int prev = j - k * points;
                        if (prev < 0) break;
                        dp[i+1][j] = (dp[i+1][j] + dp[i][prev]) % MOD;
                    }
                }
            }
            return dp[n][target];
        }
    }
}
