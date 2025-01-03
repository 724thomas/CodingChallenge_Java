package Leetcode;

import java.util.*;

public class Q502 {
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;

            List<int[]> sortedProjects = new ArrayList<>();
            for (int i=0; i<n; i++) {
                sortedProjects.add(new int[]{capital[i], profits[i]});
            }
            Collections.sort(sortedProjects, (a, b) -> a[0]-b[0]);
            Deque<int[]> allProjectsDeque = new ArrayDeque<>(sortedProjects);

            PriorityQueue<int[]> candidProjects = new PriorityQueue<>((a, b) -> b[1]-a[1]);
            for (int i=0; i<k; i++) {
                while (!allProjectsDeque.isEmpty() && w >= allProjectsDeque.peekFirst()[0]) {
                    candidProjects.offer(allProjectsDeque.pollFirst());
                }
                if (candidProjects.isEmpty()) return w;
                w += candidProjects.poll()[1];
            }
            return w;
        }
    }
}
