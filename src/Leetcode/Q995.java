package Leetcode;

public class Q995 {
    class Solution {
        public int minKBitFlips(int[] nums, int k) {
            int n = nums.length;
            int flips = 0, totalFlips = 0;
            int[] flipped = new int[n];

            for (int i = 0; i < n; i++) {
                if (i >= k) totalFlips = (totalFlips + flipped[i - k]) % 2; // flip

                if ((nums[i] + totalFlips) % 2 == 0) {
                    if (i + k > n) return -1;
                    flipped[i] = 1;
                    totalFlips = (totalFlips + 1) % 2; // flip
                    flips++;
                }
            }

            return flips;
        }
    }

}
