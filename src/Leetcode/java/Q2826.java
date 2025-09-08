package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.List;

public class Q2826 {
    class Solution {
        public int minimumOperations(List<Integer> nums) {
            int n = nums.size();
            int[][] dp = new int[n+1][4]; //i번째 인덱스전까지, 마지막이 1,2,3일때 최소 삭제 값.

            int val = nums.get(0);
            if (val == 1) {
                dp[0][1] = 0;
                dp[0][2] = 1;
                dp[0][3] = 1;
            } else if (val == 2) {
                dp[0][1] = 1;
                dp[0][2] = 0;
                dp[0][3] = 1;
            } else if (val == 3) {
                dp[0][1] = 1;
                dp[0][2] = 1;
                dp[0][3] = 0;
            }

            for (int i=1; i<n; i++) {
                val = nums.get(i);
                if (val == 1) {
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2]+1;
                    dp[i][3] = dp[i-1][3]+1;
                } else if (val == 2) {
                    dp[i][1] = dp[i-1][1]+1;
                    dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]);
                    dp[i][3] = dp[i-1][3]+1;
                } else if (val == 3) {
                    dp[i][1] = dp[i-1][1]+1;
                    dp[i][2] = dp[i-1][2]+1;
                    dp[i][3] = Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3]));
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int i=0; i<3; i++) {
                ans = Math.min(ans, dp[n-1][i+1]);
            }

            return ans;
        }
    }
}
