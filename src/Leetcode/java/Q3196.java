package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3196 {
    class Solution {
        public long maximumTotalCost(int[] nums) {
            int n = nums.length;
            long[][] dp = new long[n][2];
            // i번째 nums까지 계산을 했을때 j가 0 이면, 마지막으로 +를 했던것, 1이면 -를 했던것.

            dp[0][0] = nums[0];
            dp[0][1] = nums[0];

            for (int i=1; i<n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + nums[i]; // + 처리
                dp[i][1] = dp[i-1][0] - nums[i]; // - 처리
            }

            // for (var a : dp) System.out.println(Arrays.toString(a));
            return Math.max(dp[n-1][0], dp[n-1][1]);
        }
    }
}
