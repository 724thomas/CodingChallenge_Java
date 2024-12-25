package Leetcode;

public class Q3105 {
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int ans = 1, prev = 0, size1 = 0, size2 = 0;

            for (int num : nums) {
                ans = Math.max(ans, Math.max(size1, size2));
                size1 = (prev < num) ? size1 + 1 : 1;
                size2 = (num < prev) ? size2 + 1 : 1;
                prev = num;
            }

            return Math.max(ans, Math.max(size1, size2));
        }
    }
}
