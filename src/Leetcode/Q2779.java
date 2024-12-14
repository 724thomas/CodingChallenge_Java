package Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q2779 {
    class Solution {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
            int N = nums.length;
            int ans = 0;

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<N; i++) {
                while (!deque.isEmpty() && deque.peekFirst() + (2*k) < nums[i]) {
                    deque.pollFirst();
                }
                deque.add(nums[i]);
                ans = Math.max(ans, deque.size());
            }
            return ans;
        }
    }
}
