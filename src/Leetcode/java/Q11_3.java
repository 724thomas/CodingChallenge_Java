package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q11_3 {
    class Solution {
        public int maxArea(int[] height) {
            int ans = 0;
            int left = 0, right = height.length-1;

            while (left < right) {
                ans = Math.max(ans, getArea(height, left, right));
                if (height[left] >= height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return ans;
        }

        public int getArea(int[] height, int left, int right) {
            int length = right - left;
            return Math.min(height[left], height[right]) * length;
        }
    }
}
