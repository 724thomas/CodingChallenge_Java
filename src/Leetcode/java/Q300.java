package Leetcode.java;

/*
1. 아이디어 :
Bottom-Up DP를 사용하여, 각 숫자에 대해 가장 긴 증가하는 부분 수열의 길이를 계산합니다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
배열 / DP
 */

import java.util.Arrays;

public class Q300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int ans = 0;
            for (int left = n-1; left>-1; left--) {
                for (int right = n-1; right > left; right--) {
                    if (nums[left] < nums[right]) {
                        dp[left] = Math.max(dp[left], dp[right] + 1);
                    }
                }
                ans = Math.max(ans, dp[left]);
                System.out.println(Arrays.toString(dp));
            }

            return ans;
        }
    }
}
