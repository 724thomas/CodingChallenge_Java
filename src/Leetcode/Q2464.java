package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2464 {
    class Solution {
        int n;
        int[] nums;
        Integer[] dp;

        public int gcd(int a, int b) {
            if (b==0) return a;
            return gcd(b, a%b);
        }

        public int dfs(int idx) {
            if (idx >= n) return 0;
            if (dp[idx] != null) return dp[idx];

            int ans = Integer.MAX_VALUE;
            int left = nums[idx];
            for (int i=idx; i<n; i++) {
                if (gcd(left, nums[i]) > 1) {
                    int right = dfs(i+1);
                    if (right == Integer.MAX_VALUE) continue; // impossible
                    ans = Math.min(ans, 1+right);
                }
            }

            dp[idx] = ans;
            return ans;
        }

        public int validSubarraySplit(int[] nums) {
            n = nums.length;
            this.nums = nums;
            dp = new Integer[n+1];
            int ans = dfs(0);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
