package Leetcode;

public class Q11 {
    class Solution {
        public int maxArea(int[] height) {
            var n = height.length;
            var left = 0;
            var right = n-1;

            int ans = 0;
            while (left<right) {
                var lheight = height[left];
                var rheight = height[right];
                var area = Math.min(lheight, rheight) * (right-left);
                ans = Math.max(ans, area);
                if (lheight < rheight) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }
}
