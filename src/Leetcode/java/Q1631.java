package Leetcode.java;

/*
1. 아이디어 :
다익스트라

2. 시간복잡도 :
O( n * m * log(n * m) )

3. 자료구조/알고리즘 :
우선순위 큐 / 다익스트라
 */

import java.util.PriorityQueue;

public class Q1631 {
    class Solution {
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
        int[][] dp;
        public int minimumEffortPath(int[][] heights) {
            int n = heights.length, m = heights[0].length;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
            // row, col, currDiff
            pq.add(new int[]{0, 0, 0});

            while (!pq.isEmpty()) {
                int[] c = pq.poll();
                int x = c[0], y = c[1], currDiff = c[2];
                if (x == n-1 && y == m-1) return currDiff;

                if (heights[x][y] == -1) continue;

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    int diff = Math.abs(heights[nx][ny] - heights[x][y]);
                    pq.add(new int[]{nx, ny, Math.max(currDiff, diff)});
                }

                heights[x][y] = -1;
            }
            return -1;
        }
    }
}
