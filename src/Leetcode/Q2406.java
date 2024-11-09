package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2406 {
    class Solution {
        public int minGroups(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝만 유지
            for (int[] interval : intervals) {
                if (!pq.isEmpty() && pq.peek() < interval[0]) pq.poll();
                pq.add(interval[1]);
            }
            return pq.size();
        }
    }
}
