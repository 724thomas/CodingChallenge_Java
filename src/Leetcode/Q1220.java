package Leetcode;

/*
1. 아이디어 :
dp 문제

2. 시간복잡도 :
O( 5 * n )

3. 자료구조/알고리즘 :
2차원 배열 / dp
 */

public class Q1220 {
    class Solution {
        int MOD = 1_000_000_007;
        public int countVowelPermutation(int n) {
        /*
        1. e a
        2. a,i e
        3. i not i
        4. i,u o
        5. u a
        */
            long[][] dp = new long[n+1][5];
            dp[1] = new long[]{1, 1, 1, 1, 1}; // a e i o u

            for (int i=2; i<n+1; i++) {
                dp[i][0] = (dp[i-1][1]) % MOD;
                dp[i][1] = (dp[i-1][0] % MOD + dp[i-1][2] % MOD) % MOD;
                dp[i][2] = (dp[i-1][0] % MOD + dp[i-1][1] % MOD + dp[i-1][3] % MOD + dp[i-1][4] % MOD) % MOD;
                dp[i][3] = (dp[i-1][2] % MOD + dp[i-1][4] % MOD) % MOD;
                dp[i][4] = (dp[i-1][0]) % MOD;
            }
            long ans = 0;
            for (int i=0; i<5; i++) ans = (ans + dp[n][i]) % MOD;
            return (int)ans;
        }
    }
}
