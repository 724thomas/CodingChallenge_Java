package Leetcode;

import java.util.Arrays;

public class Q1968 {
    class Solution {
        public int[] rearrangeArray(int[] nums) {
            Arrays.sort(nums);

            int left = 0;
            int right = (int)Math.ceil((double)nums.length/2);
            int[] ans = new int[nums.length];
            for (int i=0; i<nums.length; i++) if (i%2 == 0) ans[i] = nums[left++]; else ans[i] = nums[right++];
            return ans;
        }
    }
}
