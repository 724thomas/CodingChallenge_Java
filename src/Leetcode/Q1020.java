package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1020 {
    class Solution {
        int N, M;
        boolean[][] visited;
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] grid;

        public int bfs(int row, int col) {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            visited[row][col] = true;

            int count = 1;
            boolean boundary = false;
            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1];
                if (x == 0 || y == 0 || x == N-1 || y == M-1) boundary = true;

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny] || grid[nx][ny] == 0) continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                    count++;
                }
            }
            return boundary ? 0 : count;
        }

        public int numEnclaves(int[][] grid) {
            N = grid.length;
            M = grid[0].length;
            this.grid = grid;
            visited = new boolean[N][M];

            int ans = 0;
            for (int i=1; i<N-1; i++) for (int j=1; j<M-1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans += bfs(i,j);
                }
            }
            return ans;
        }
    }
}
