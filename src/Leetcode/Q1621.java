package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1621 {
    class Solution {
        int MOD = 1_000_000_007;

        public int numberOfSets(int n, int k) {
            long[][][] dp = new long[n][k+1][3];
            // i번째 점을 건너뜀
            // i번쨰 점이 직전 선과 연장됨
            // i번째 점이 새로운 선으로 만들어짐
            dp[0][0][0] = 1;
            // 0개의 선을 만들고, 0번쨰 점은 사용하지 않는 경우
            // [0][0][1] 은 연장인데, 연장될 수 없음
            // [0][0][2]는 새로운 선으로 만들어져야하는데, 점 하나로는 불가능

            for (int i=1; i<n; i++) {
                for (int line=0; line<=k; line++) {
                    // 건너뛰는 경우
                    dp[i][line][0] = (dp[i-1][line][0] + dp[i-1][line][1] + dp[i-1][line][2]) % MOD;

                    // 연장하는 경우
                    dp[i][line][1] = (dp[i-1][line][1] + dp[i-1][line][2]) % MOD;

                    if (line == 0) continue; // 선이 1개라도 존재해야함

                    // 새로운 선을 만드는 경우
                    dp[i][line][2] = (dp[i-1][line-1][0] + dp[i-1][line-1][1] + dp[i-1][line-1][2]) % MOD;
                }
            }
            long ans = (dp[n-1][k][0] + dp[n-1][k][1] + dp[n-1][k][2]) % MOD;
            return (int) ans;
        }
    }
}
