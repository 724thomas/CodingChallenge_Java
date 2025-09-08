package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int n = nums.length;

            int left = 0, right = 0;
            int total = 0;
            while (right<n) {
                total += nums[right++];
                while (total >= target) {
                    total -= nums[left++];
                    ans = Math.min(ans, right - left + 1);
                }
            }


            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
