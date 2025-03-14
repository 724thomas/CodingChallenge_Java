package Leetcode;

/*
1. 아이디어 :
dp를 사용합니다.
dp[i]는 i번째까지 과일을 샀을때의 최소값입니다.
i+1번쨰 과일을 살때, i+1번쨰부터 i+i+2까지의 과일을 무료로 살 수 있습니다.
따라서 dp[i] = dp[i-1] + prices[i]로 갱신합니다.

2. 시간복잡도 :
O( n**2 )

3. 자료구조/알고리즘 :
배열 / dp
 */

import java.util.Arrays;

public class Q2944 {
    class Solution {
        public int minimumCoins(int[] prices) {
            int n = prices.length;
            if (n==1) return prices[0];
            int[] dp = new int[n]; //n까지 다 샀을때의 최소값
            Arrays.fill(dp, Integer.MAX_VALUE);

            dp[0] = prices[0];
            dp[1] = prices[0];
            for (int i=1; i<n; i++) {
                for (int j = i; j<i+i+2 && j<n; j++) {
                    dp[j] = Math.min(dp[j], dp[i-1] + prices[i]);
                }
            }

            return dp[n-1];

        }
    }
}
