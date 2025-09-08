package Leetcode.java;

import java.util.PriorityQueue;

public class Q3296 {

    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) return Long.compare(a[2], b[2]);
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[0], b[0]);
            });

            for (int time : workerTimes) {
                pq.add(new long[]{time, time, 1});
            }

            while (mountainHeight > 1) {
                long[] curr = pq.poll();
                long ps = curr[0], wt = curr[1], x = curr[2];

                pq.offer(new long[]{ps + wt * (x + 1), wt, x + 1});
                mountainHeight--;
            }

            return pq.poll()[0];
        }
    }

}
