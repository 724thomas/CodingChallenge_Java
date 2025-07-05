package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2473 {

    class Solution {
        Map<Integer, List<int[]>> graph;
        int n;
        int[] appleCost;
        int k;

        public long getMinCost(int start) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(); // [node, dist]
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[start] = 0;
            pq.add(new long[] { start, 0 });

            long minCost = appleCost[start];

            while (!pq.isEmpty()) {
                long[] curr = pq.poll();
                int u = (int) curr[0];
                long d = curr[1];

                if (d > dist[u]) continue; // 이미 더 짧은 거리로 방문한 경우

                minCost = Math.min(minCost, appleCost[u] + d * (k + 1));

                for (int[] edge : graph.getOrDefault(u, new ArrayList<>())) {
                    int v = edge[0], w = edge[1];
                    if (dist[v] > d + w) {
                        dist[v] = d + w;
                        pq.add(new long[] { v, dist[v] });
                    }
                }
            }
            return minCost;
        }

        public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
            this.n = n;
            this.appleCost = appleCost;
            this.k = k;
            graph = new HashMap<>();

            for (int[] r : roads) {
                int u = r[0] - 1, v = r[1] - 1, d = r[2];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(new int[] { v, d });
                graph.get(v).add(new int[] { u, d });
            }

            long[] ans = new long[n];
            for (int u = 0; u < n; u++) {
                ans[u] = getMinCost(u);
            }
            return ans;
        }
    }

}
