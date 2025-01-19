package Leetcode;

public class Q1150 {
    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            int n = nums.length;
            int count = getBound(nums, target, false) - getBound(nums, target, true);
            return count > n / 2;
        }

        public int getBound(int[] nums, int target, boolean isLower) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    if(isLower) right = mid; else left = mid +1;
                }
                else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left;
        }
    }

}
