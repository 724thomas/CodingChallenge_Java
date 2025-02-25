package Leetcode;

/*
1. 아이디어 :
dp를 사용해서, stock을 가지고 있는 상태(0)와 가지고 있지 않은 상태(1)를 유지합니다.
- 가지고 있는 경우, 팔거나 팔지 않았을때의 최대값
- 가지고 있지 않은 경우, 사거나, 사지 않았을때의 최대값
마지막에 팔았을때의 최대값을 구합니다.
2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / DP
 */

public class Q714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];

            dp[0][0] = 0; // no stock
            dp[0][1] = -prices[0]; // have a stock

            for (int i = 1; i < n; i++)
            {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee); // sell
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // buy
            }

            return dp[n - 1][0];
        }
    }
}
