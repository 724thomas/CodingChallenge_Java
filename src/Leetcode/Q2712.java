package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2712 {
    class Solution {
        public long minimumCost(String s) {
            int n = s.length();
            if (n==1) return 0;
            int half = n/2;
            long[][] dp = new long[n][2]; // idx, 0/1

            if (s.charAt(0) == '0') {
                dp[0][0] = 0;
                dp[0][1] = 1;
            } else {
                dp[0][0] = 1;
                dp[0][1] = 0;
            }

            if (s.charAt(n-1) == '0') {
                dp[n-1][0] = 0;
                dp[n-1][1] = 1;
            } else {
                dp[n-1][0] = 1;
                dp[n-1][1] = 0;
            }

            for (int i=1; i<half; i++) {
                char left = s.charAt(i);
                if (left == '0') {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][0] + (i+1);
                } else if (left == '1') {
                    dp[i][0] = dp[i-1][1] + (i+1);
                    dp[i][1] = dp[i-1][1];
                }

                char right = s.charAt(n-1-i);
                if (right == '0') {
                    dp[n-1-i][0] = dp[n-i][0];
                    dp[n-1-i][1] = dp[n-i][0] + (i+1);
                } else if (right == '1') {
                    dp[n-1-i][0] = dp[n-i][1] + (i+1);
                    dp[n-1-i][1] = dp[n-i][1];
                }
            }


            if (n%2 == 0) {
                return Math.min(dp[half-1][0]+dp[half][0], dp[half-1][1] + dp[half][1]);
            }

            return (s.charAt(half) == '0')?
                    dp[half-1][0] + dp[half+1][0] : dp[half-1][1] + dp[half+1][1];

        }
    }
}
