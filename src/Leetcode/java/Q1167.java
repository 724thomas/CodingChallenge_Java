package Leetcode.java;

import java.util.PriorityQueue;

public class Q1167 {
    class Solution {
        public int connectSticks(int[] sticks) {
            int ans = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int stick : sticks) pq.add(stick);
            while (pq.size()!=1) {
                int a = pq.poll() + pq.poll();
                pq.add(a);
                ans += a;
            }

            return ans;
        }
    }
}
