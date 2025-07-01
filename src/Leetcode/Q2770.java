package Leetcode;

/*
1. 아이디어 :
dp를 사용해서 최대값을 구합니다.
start에서 end로 이동할 때, nums[end] - nums[start]의 절대값이 target 이하인지 확인.
가능하다면 dp[end]를 갱신.

2. 시간복잡도 :
O( n * n)

3. 자료구조/알고리즘 :
배열 / DP
 */

import java.util.Arrays;

public class Q2770 {
    class Solution {
        public int maximumJumps(int[] nums, int target) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for (int start = 0; start < n; start++) {
                if (dp[start] == -1) continue;
                for (int end = start + 1; end < n; end++) {
                    int diff = nums[end] - nums[start];
                    if (Math.abs(diff) <= target) dp[end] = Math.max(dp[end], dp[start]+1);
                }
            }

            return dp[n-1];
        }
    }
}
