package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q743 {

    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {

            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int[] t : times) {
                graph.putIfAbsent(t[0], new ArrayList<>());
                graph.get(t[0]).add(new int[]{t[1], t[2]});
            }

            PriorityQueue<int[]> pq =
                    new PriorityQueue<>((a, b) -> a[1] - b[1]); // 거리 기준

            pq.add(new int[]{k, 0});

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[k] = 0;

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0];
                int time = curr[1];

                if (time > dist[node]) continue;

                for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
                    int nextNode = next[0];
                    int weight = next[1];

                    if (dist[nextNode] > time + weight) {
                        dist[nextNode] = time + weight;
                        pq.add(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) return -1;
                ans = Math.max(ans, dist[i]);
            }

            return ans;
        }
    }

}
