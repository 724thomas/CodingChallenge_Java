package Leetcode.java;

/*
1. 아이디어 :
전형적 dp 문제

2. 시간복잡도 :
O( n * 5000 )

3. 자료구조/알고리즘 :
dp
 */

public class Q518 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int a = coin; a <= amount; a++) {
                    dp[a] += dp[a-coin];
                }
            }
            return dp[amount];
        }
    }
}
