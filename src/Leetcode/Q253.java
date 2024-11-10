package Leetcode;

public class Q253 {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a,b)->a[0]-b[0]);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int ans = 0;
            for (int i=0; i<intervals.length; i++) {
                int start = intervals[i][0], end = intervals[i][1];
                while (!pq.isEmpty() && pq.peek() <= start) {
                    pq.poll();
                }
                pq.offer(end);
                ans = Math.max(ans, pq.size());
            }
            return ans;
        }
    }
}
