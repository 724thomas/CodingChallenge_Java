package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2750 {
    class Solution {
        public int numberOfGoodSubarraySplits(int[] nums) {
            int MOD = 1_000_000_007;
            int n = nums.length;

            int idx = -1;
            for (int i=0; i<n; i++) {
                if (nums[i] == 1) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) return 0;
            long ans = 1;
            for (int i=idx+1; i<n; i++) {
                if (nums[i] == 1) {
                    ans  = (ans * (i-idx)) % MOD;
                    idx = i;
                }
            }

            return (int)ans;
        }
    }
}
