package Leetcode.java;

/*
1. 아이디어 :
다익스트라

2. 시간복잡도 :
O( n * m * log(n*m) )

3. 자료구조/알고리즘 :
다익스트라
 */

import java.util.PriorityQueue;

public class Q778 {
    class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int time = 0;
            int[] dx = new int[]{0,0,1,-1};
            int[] dy = new int[]{1,-1,0,0};
            boolean[][] visited = new boolean[n][m];

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a,b) -> a[0]-b[0]
            );

            pq.add(new int[]{grid[0][0], 0, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time = cur[0];
                int x = cur[1], y = cur[2];

                if (visited[x][y]) continue;
                visited[x][y] = true;

                if (x == n - 1 && y == m - 1) return time;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;

                    int nextTime = Math.max(time, grid[nx][ny]);
                    pq.add(new int[]{nextTime, nx, ny});
                }
            }
            return -1;
        }
    }
}
