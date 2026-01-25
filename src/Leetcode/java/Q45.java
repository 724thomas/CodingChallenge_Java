package Leetcode.java;

/*
1. 아이디어 :
dfs, backtrack은 시간초과.
memoization 필요.
또는 bottom up 방식 dp

2. 시간복잡도 :
O( a * n )

3. 자료구조/알고리즘 :
dp
 */

import java.util.Arrays;

public class Q45 {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i=0; i<n; i++) {
                int currMin = dp[i];
                int maxJump = nums[i];
                for (int j=i; j<=i+maxJump; j++) {
                    if (j >= n) continue;
                    dp[j] = Math.min(dp[j], currMin+1);
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[n-1];
        }
    }
}
