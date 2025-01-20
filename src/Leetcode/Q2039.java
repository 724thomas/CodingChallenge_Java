package Leetcode;

import java.util.*;

public class Q2039 {
    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int nodes = patience.length;
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i=0; i<nodes; i++) graph.put(i, new ArrayList<>());

            for (int[] e:edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }

            int[] dist = new int[nodes];
            Arrays.fill(dist, -1);
            dist[0] = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0}); //node, time;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int c = curr[0], d = curr[1];

                for (int neighbor : graph.get(c)) {
                    if (dist[neighbor] != -1) continue;
                    dist[neighbor] = d+1;
                    queue.add(new int[]{neighbor, d+1});
                }
            }

            int ans = 0;
            for (int i=1; i<nodes; i++) {
                int totalTime = dist[i] * 2;
                int lastSend = ((totalTime - 1) / patience[i]) * patience[i];
                int lastReply = lastSend + totalTime;
                ans = Math.max(ans, lastReply);
            }
            return ans+1;
        }
    }
}
