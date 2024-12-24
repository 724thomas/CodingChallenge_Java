package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q463 {
    class Solution {
        int[][] grid;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int N;
        int M;

        public int getSurface(int x, int y) {
            int surfaces = 0;
            for (int i =0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx<0 || ny <0 || nx >=N || ny>=M || grid[nx][ny] == 0 ) surfaces++;
            }
            return surfaces;
        }

        public int bfs(int row, int col) {
            int totalSurfaces = 0;

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            boolean[][] visited = new boolean[N][M];
            visited[row][col] = true;

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1];
                totalSurfaces += getSurface(x, y);

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny <0 || nx >=N || ny>=M || grid[nx][ny] == 0 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }


            return totalSurfaces;
        }

        public int islandPerimeter(int[][] grid) {
            N = grid.length;
            M = grid[0].length;
            this.grid = grid;
            for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
                if (grid[i][j] == 1) {
                    return bfs(i, j);
                }
            }
            return 0;
        }
    }
}
