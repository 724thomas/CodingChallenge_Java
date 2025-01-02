package Leetcode;

public class Q3010 {
    class Solution {
        public int minimumCost(int[] nums) {
            int small = Integer.MAX_VALUE, smaller= Integer.MAX_VALUE;

            for (int i=1; i<nums.length; i++) {
                if (nums[i] < smaller) {
                    small = smaller;
                    smaller = nums[i];
                } else if (nums[i] < small) {
                    small = nums[i];
                }
            }
            return nums[0] + smaller + small;
        }
    }
}
