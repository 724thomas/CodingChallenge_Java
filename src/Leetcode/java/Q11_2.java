package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q11_2 {
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;

            int left = 0, right = n-1;
            int ans = 0;
            while (left < right) {
                ans = Math.max(ans, (right-left) * Math.min(height[left], height[right]));
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return ans;
        }
    }
}
