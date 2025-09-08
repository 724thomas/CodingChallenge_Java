package Leetcode.java;

import java.util.PriorityQueue;

public class Q2558 {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            for (int gift: gifts) pq.add(gift);
            for (int i=0; i<k; i++) pq.add((int)Math.sqrt(pq.poll()));
            long ans = 0;
            while (!pq.isEmpty()) ans += pq.poll();
            return ans;
        }
    }
}
