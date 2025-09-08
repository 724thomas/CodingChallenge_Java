package Leetcode.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1942 {
    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            int n = times.length;
            PriorityQueue<Integer> vacants = new PriorityQueue<>((a, b) -> a-b); // chair
            for (int i=0; i<n; i++) vacants.add(i);
            PriorityQueue<int[]> toBeVacant = new PriorityQueue<>((a,b) -> a[0]-b[0]); // endtime, chair

            int[][] newtimes = new int[n][3];
            for (int i=0; i<n; i++) newtimes[i] = new int[]{times[i][0],times[i][1],i};
            Arrays.sort(newtimes, (a, b) -> a[0] - b[0]);

            for (int i=0; i<n; i++) {
                int start = newtimes[i][0], end = newtimes[i][1], friend = newtimes[i][2];
                while (!toBeVacant.isEmpty() && toBeVacant.peek()[0] <= start) vacants.add(toBeVacant.poll()[1]);
                int nextChair = vacants.poll();
                if (friend == targetFriend) return nextChair;
                toBeVacant.add(new int[]{end, nextChair});
            }
            return vacants.poll();
        }
    }
}
