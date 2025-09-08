package Leetcode.java;

public class Q2044 {
    class Solution {
        int maxOr = 0;

        public int dfs(int i, int currOr, int[] nums) {
            return i == nums.length ? (currOr == maxOr ? 1:0) : (dfs(i+1, currOr, nums) + dfs(i+1, currOr | nums[i], nums));
        }

        public int countMaxOrSubsets(int[] nums) {
            for (int num : nums) maxOr = maxOr | num;
            return dfs(0, 0, nums);
        }
    }
}
