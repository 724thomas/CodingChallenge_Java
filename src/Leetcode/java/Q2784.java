package Leetcode.java;

public class Q2784 {
    class Solution {
        public boolean isGood(int[] nums) {
            int N = nums.length - 1;
            int[] counter = new int[201];

            for (int num : nums)
                counter[num]++;

            for (int i = 1; i < N; i++)
                if (counter[i] != 1)
                    return false;

            return counter[N] == 2 ? true : false;
        }
    }
}
