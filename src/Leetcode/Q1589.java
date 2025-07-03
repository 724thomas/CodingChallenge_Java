package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q1589 {
    class Solution {
        public int maxSumRangeQuery(int[] nums, int[][] requests) {
            int n = nums.length;
            int MOD = 1_000_000_007;
            int[] prefix = new int[n+1];
            for (int[] r : requests) {
                prefix[r[0]]++;
                prefix[r[1]+1]--;
            }
            for (int i=1; i<n+1; i++) {
                prefix[i] += prefix[i-1];
            }
            Arrays.sort(prefix);
            Arrays.sort(nums);

            long ans = 0;
            for (int i=0; i<n; i++) {
                ans = (ans + 1L * prefix[i+1] * nums[i]) % MOD;
            }
            return (int)ans;
        }
    }
}
