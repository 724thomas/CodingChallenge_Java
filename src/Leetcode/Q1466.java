package Leetcode;

import java.util.*;

public class Q1466 {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
            for ( int[] connection : connections ) {
                int start = connection[0], end = connection[1];
                graph.putIfAbsent(start, new ArrayList<>());
                graph.putIfAbsent(end, new ArrayList<>());
                graph.get(start).add(new int[]{end, 1});
                graph.get(end).add(new int[]{start, -1});
            }

            boolean[] visited = new boolean[n];
            visited[0] = true;
            Queue<Integer> deque = new LinkedList<>();
            deque.add(0);

            int ans = 0;
            while(!deque.isEmpty()) {
                int par = deque.poll();
                for (int[] childInfo : graph.get(par)) {
                    int child = childInfo[0], dir = childInfo[1];
                    if (visited[child]) continue;
                    visited[child]=true;
                    if (dir == 1) ans++;
                    deque.add(child);
                }
            }
            return ans;
        }
    }
}
