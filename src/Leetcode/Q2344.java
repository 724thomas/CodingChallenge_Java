package Leetcode;

import java.util.Arrays;

public class Q2344 {
    class Solution {
        public int gcd(int a, int b) {
            while (b!=0) {
                int temp = b;
                b = a%b;
                a = temp;
            }
            return a;
        }

        public int gcdArray(int[] nums) {
            int ans = nums[0];
            for (int i=1; i<nums.length && ans!=1; i++) ans = gcd(ans, nums[i]);
            return ans;
        }
        public int minOperations(int[] nums, int[] numsDivide) {
            Arrays.sort(nums);
            int gcd = gcdArray(numsDivide);

            for (int i=0; i<nums.length; i++) if (gcd % nums[i] == 0) return i;
            return -1;
        }
    }
}
