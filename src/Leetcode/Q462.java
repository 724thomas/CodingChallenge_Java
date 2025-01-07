package Leetcode;

import java.util.Arrays;

public class Q462 {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int mid = nums[nums.length/2];
            int ans = 0;
            for (int num: nums) ans += Math.abs(mid - num);
            return ans;
        }
    }
}
