package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q518_2 {
    class Solution {
        int ans = 0;
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount+1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int curr = coin; curr <= amount; curr++) {
                    dp[curr] += dp[curr - coin];
                }
            }

            return dp[amount];
        }

    }
}
