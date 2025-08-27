package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    class Solution {
        public int maxEvents(int[][] events) {
            int n = events.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int removed = 0;
            int day = 0;
            int ans = 0;
            int idx = 0;
            Arrays.sort(events, (a, b) -> a[0]-b[0]);
            while (removed < events.length) {
                while (idx < n && events[idx][0] <= day) {
                    pq.add(events[idx++][1]);
                }

                while (!pq.isEmpty() && pq.peek() < day) {
                    pq.poll();
                    removed++;
                }
                if (!pq.isEmpty()) {
                    ans++;
                    pq.poll();
                    removed++;
                }
                day++;
            }
            return ans;
        }
    }
}
