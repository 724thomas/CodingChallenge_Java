package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q1584 {
    class Solution {
        public int getCost(int[] p1, int[] p2) {
            return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1] - p2[1]);
        }
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            int[][] neighbors = new int[n][n];
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                int cost = getCost(points[i], points[j]);
                neighbors[i][j] = cost;
                neighbors[j][i] = cost;
            }

            int ans = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]); // distance, points
            boolean[] visited = new boolean[n];
            // start = 0;
            visited[0] = true;
            for (int i=0; i<n; i++) pq.add(new int[]{neighbors[0][i], i});

            while (!pq.isEmpty()) {
                while (!pq.isEmpty() && visited[pq.peek()[1]]) pq.poll();
                if (pq.isEmpty()) break;
                int[] closest = pq.poll();
                visited[closest[1]] = true;
                ans += closest[0];

                for (int i=0; i<n; i++) {
                    if (!visited[i]) pq.add(new int[]{neighbors[closest[1]][i], i});
                }
            }

            return ans;
        }
    }
}
