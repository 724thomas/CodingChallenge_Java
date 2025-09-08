package Leetcode.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q317 {
    public class Solution {
        int N, M, buildings = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        public int shortestDistance(int[][] grid) {
            N = grid.length;
            M = grid[0].length;

            int[][] totalDistance = new int[N][M];
            int[][] reach = new int[N][M];

            for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    bfs(i, j, grid, totalDistance, reach);
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) ans = Math.min(ans, totalDistance[i][j]);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private void bfs(int x, int y, int[][] grid, int[][] totalDistance, int[][] reach) {
            boolean[][] visited = new boolean[N][M];
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{x, y, 0});
            visited[x][y] = true;

            while (!deque.isEmpty()) {
                int[] cur = deque.poll();
                int cx = cur[0], cy = cur[1], dist = cur[2];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i], ny = cy + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny] || grid[nx][ny] != 0) continue;
                    visited[nx][ny] = true;
                    totalDistance[nx][ny] += dist + 1;
                    reach[nx][ny]++;
                    deque.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
    }

}
