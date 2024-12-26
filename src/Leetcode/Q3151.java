package Leetcode;

public class Q3151 {
    class Solution {
        public boolean isArraySpecial(int[] nums) {
            for (int i=0; i<nums.length-1; i++) {
                if (nums[i]%2 + nums[i+1]%2 != 1) return false;
            }
            return true;
        }
    }
}
