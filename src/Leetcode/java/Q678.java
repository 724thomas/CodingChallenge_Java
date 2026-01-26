package Leetcode.java;

/*
1. 아이디어 :
모든 조합을 구해서 balance가 0인 경우를 찾아야함.
n <= 100이라서 백트래킹은 불가. Memoization 필요
dp로 index(x)와 balance(y) 경우들을 추적

2. 시간복잡도 :
O( n*n )

3. 자료구조/알고리즘 :
dp
 */

public class Q678 {
    class Solution {
        public boolean checkValidString(String s) {
            int n = s.length();
            // (idx, balance)

            int[][] dp = new int[n+1][n+1];
            if (s.charAt(0) == '(') {
                dp[0][1] = 1;
            } else if (s.charAt(0) == '*') {
                dp[0][1] = 1;
                dp[0][0] = 1;
            } else {
                return false;
            }

            for (int i=1; i<n; i++) {
                char c = s.charAt(i);

                for (int j=0; j<n; j++) {
                    if (c == '(') {
                        if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                    } else if (c == ')') {
                        if (j+1 <= n) dp[i][j] += dp[i-1][j+1];
                    } else {
                        if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];

                        dp[i][j] += dp[i-1][j];

                        if (j+1 < n) dp[i][j] += dp[i-1][j+1];
                    }
                }
            }
            return dp[n-1][0] != 0;
        }
    }

/**
 (*))

 0 1 2 3 (index 길이)
 0 0 1 1 1
 1 1 1 1 0
 2 0 1 0 0
 3 0 0 0 0
 (balance)
 */
}
