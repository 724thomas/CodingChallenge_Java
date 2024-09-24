package Leetcode;

import java.util.Arrays;

public class Q1679 {
    class Solution {
        public int maxOperations(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);

            int left = 0, right = n-1;
            int ans = 0;
            while (left < right) {
                int total = nums[left] + nums[right];
                if (total == k) {
                    ans++;
                    left++;
                    right--;
                } else if (total < k) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }
}
