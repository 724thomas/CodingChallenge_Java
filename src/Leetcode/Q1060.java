package Leetcode;

public class Q1060 {
    class Solution {
        public int missingElement(int[] nums, int k) {
        /*
        missing numbers
        nums[i] - nums[0] + 1 - (i + 1)
        ith num, 0th num + boundary - (i+1 existing nums)
        */
            int n = nums.length;
            int left = 0, right = n - 1;

            while (left < right) {
                int mid = right - (right-left)/2;
                int missings = nums[mid] - nums[0] +1 - (mid + 1);

                if (missings < k) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return nums[0] + k + left;
        }
    }
}
