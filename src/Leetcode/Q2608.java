package Leetcode;

import java.util.*;

public class Q2608 {
    class Solution {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n;
        int[][] edges;
        int ans = Integer.MAX_VALUE;

        public int bfs(int start) {
            boolean[] visited = new boolean[n];

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{start, -1, 0}); //curr, prev, dist;

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int curr = c[0], prev = c[1], dist = c[2];
                if (dist >= ans) return ans;

                for (int next : graph.get(curr)) {

                    if (next == prev) continue;
                    if (next == start) return dist+1;
                    visited[next]=true;
                    deque.add(new int[]{next, curr, dist+1});
                }
            }
            return ans;
        }

        public int findShortestCycle(int n, int[][] edges) {
            this.n = n;
            this.edges = edges;

            for (int i=0; i<n; i++) graph.put(i, new ArrayList<>());
            for (int[] e: edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }

            for (int i=0; i<n; i++) ans = bfs(i);

            return ans == Integer.MAX_VALUE? -1 : ans;
        }
    }
}
