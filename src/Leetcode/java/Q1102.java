package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q1102 {
    class Solution {
        public int maximumMinimumPath(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            boolean[][] visited = new boolean[n][m];

            int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

            int ans = grid[0][0];
            visited[0][0] = true;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0] - a[0]); // val, x, y
            pq.add(new int[]{grid[0][0],0,0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int val = curr[0], x = curr[1], y = curr[2];
                ans = Math.min(ans, val);
                if (x==n-1 && y==m-1) return ans;

                for (int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y+dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    pq.add(new int[]{grid[nx][ny], nx, ny});
                }
            }

            return ans;

        }
    }
}
