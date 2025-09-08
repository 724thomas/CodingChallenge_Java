package Leetcode.java;

public class Q962 {
    class Solution {
        public int maxWidthRamp(int[] nums) {
            int ans = 0;
            int[] rights = new int[nums.length];
            int cmax = 0;
            for (int i=nums.length-1; i>-1; i--) {
                if (nums[i] > cmax) cmax = nums[i];
                rights[i] = cmax;
            }

            int left = 0;
            for (int right=1; right<nums.length; right++) {
                if (nums[left] <= nums[right]){
                    ans = Math.max(ans, right - left);
                } else {
                    while (nums[left] > rights[right]) {
                        left++;
                    }
                }
            }
            return ans;

        }
    }
}
