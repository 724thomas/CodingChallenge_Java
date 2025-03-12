package Leetcode;

/*
1. 아이디어 :
dp를 사용.
최소 길이 3을 만족하면 더 큰 길이도 만족.
dp[i]는 0번째부터 i번째까지 k를 만족시키기 위한 최소 연산 횟수
dp[i] = min(dp[i-3], dp[i-2], dp[i-1]) + 현재 num과 k의 차이
정답은 dp[n-1], dp[n-2], dp[n-3] 중 최소값

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / dp
 */

public class Q2919 {
    class Solution {
        public long minIncrementOperations(int[] nums, int k) {
            int n= nums.length;
            long[] dp = new long[n];
            for (int i=0; i<n; i++) {
                int diff = Math.max(0, k - nums[i]);
                dp[i] = (i<3) ? diff : Math.min(dp[i-3], Math.min(dp[i-2], dp[i-1])) + diff;
            }
            return Math.min(dp[n-1], Math.min(dp[n-2], dp[n-3]));

        }
    }
}
