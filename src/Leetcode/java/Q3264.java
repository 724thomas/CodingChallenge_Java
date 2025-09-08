package Leetcode.java;

import java.util.PriorityQueue;

public class Q3264 {
    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }); // value, index
            for (int i=0; i<nums.length; i++) pq.offer(new int[]{nums[i], i});
            for (int i=0; i<k; i++) {
                int[] curr = pq.poll();
                int multVal = curr[0] * multiplier;
                nums[curr[1]] = multVal;
                pq.offer(new int[]{multVal, curr[1]});
            }
            return nums;
        }
    }
}
