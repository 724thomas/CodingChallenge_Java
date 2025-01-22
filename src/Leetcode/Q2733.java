package Leetcode;

public class Q2733 {
    class Solution {
        public int findNonMinOrMax(int[] nums) {
            int cmin = nums[0], cmax = nums[0];
            for (int num: nums) {
                if (num < cmin) {
                    if (cmin != cmax) return cmin; else cmin = num;
                } else if (cmax < num) {
                    if (cmin != cmax) return cmax; else cmax = num;
                } else {
                    if (cmin != cmax) return num;
                }
            }
            return -1;
        }
    }
}
