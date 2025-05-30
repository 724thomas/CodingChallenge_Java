package Leetcode;

/*
1. 아이디어 :
다익스트라 사용

2. 시간복잡도 :
O( n * log n + m ) // n: 노드, m: 엣지

3. 자료구조/알고리즘 :
해시맵 / 다익스트라
 */

import java.util.*;

public class Q1928 {
    class Pair {
        int node;
        int time;
        int fees;
        public Pair(int node, int time, int fees) {
            this.node=node;
            this.time=time;
            this.fees=fees;
        }
    }

    class Solution {
        public int minCost(int maxTime, int[][] edges, int[] passingFees) {
            // n: nodes, m: edges
            int n = passingFees.length;
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : edges) {  // m
                int u = edge[0], v = edge[1], c = edge[2];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(new int[]{v, c});
                graph.get(v).add(new int[]{u, c});
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                return a.fees - b.fees;
            });
            pq.add(new Pair(0,0,passingFees[0]));

            int[][] dp = new int[n][maxTime+1]; // [x][y] = x노드에 y시간에 도착했을때, 최소 fees
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
            dp[0][0] = passingFees[0];

            while (!pq.isEmpty()) { // n
                Pair curr = pq.poll(); // logn
                int cnode = curr.node, ctime = curr.time, cfees = curr.fees;
                if (dp[cnode][ctime] != cfees) continue;
                if (cnode == n-1) return cfees;

                for (int[] neighbor : graph.getOrDefault(cnode, new ArrayList<>())) { // m
                    int nnode = neighbor[0], ntime = neighbor[1], nfees = passingFees[neighbor[0]];
                    if (ctime + ntime > maxTime || dp[nnode][ctime + ntime] <= cfees + nfees) continue;
                    dp[nnode][ctime+ntime] = cfees + nfees;
                    pq.add(new Pair(nnode, ctime+ntime, cfees + nfees));
                }
            }
            return -1;
        }
    }
}
