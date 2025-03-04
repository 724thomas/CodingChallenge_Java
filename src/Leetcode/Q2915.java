package Leetcode;

/*
1. 아이디어 :
dp를 사용합니다
dp[i][j]는 i번째까지의 수를 사용해서 j를 만들 수 있는 최대 부분 수열의 길이입니다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
배열 / dp
 */

import java.util.Arrays;
import java.util.List;

public class Q2915 {

    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int n = nums.size();
            int[][] dp = new int[n+1][target+1];

            for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
            dp[0][0] = 0;

            for (int i = 0; i < n; i++) {
                int curr = nums.get(i);
                for (int j = 0; j <= target; j++) {
                    if (dp[i][j] == -1) continue;

                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                    if (j + curr > target) continue;
                    dp[i+1][j+curr] = Math.max(dp[i+1][j+curr], dp[i][j] + 1);
                }
            }

            return dp[n][target];
        }
    }

}
