package Leetcode.java;

/*
1. 아이디어 :
dp = int[2]를 통해, dp[0]은 짝수개 선택시 최대합, dp[1]은 홀수개 선택시 최대합을 저장
dp[0]은 현재 짝수개에서 유지하거나, 현재 홀수개에서 이번 수를 빼서 짝수개로 만드는 경우
dp[1]은 현재 홀수개에서 유지하거나, 현재 짝수개에서 이번 수를 더해서 홀수개로 만드는 경우

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / dp
 */

public class Q1911 {
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[] dp = new long[]{0, nums[0]}; // 짝수개, 홀수개

            for (int i=1; i<n; i++) {
                long evenMax = Math.max(dp[0], dp[1] - nums[i]);
                long oddMax = Math.max(dp[1], dp[0] + nums[i]);
                dp = new long[]{evenMax, oddMax};
            }
            return Math.max(dp[0], dp[1]);

        }
    }
}
