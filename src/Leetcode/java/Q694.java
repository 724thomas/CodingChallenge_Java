package Leetcode.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Q694 {
    class Solution {
        Set<String> visited = new HashSet<>();
        int[][] grid;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int N, M;

        public void bfs(int row, int col) {
            StringBuilder path = new StringBuilder();

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            grid[row][col] = 0;

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1];
                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny <0 || nx >=N || ny >= M || grid[nx][ny] == 0) continue;
                    grid[nx][ny] = 0;
                    path.append(i);
                    deque.add(new int[]{nx, ny});
                }
                path.append("-1");
            }
            visited.add(path.toString());
        }

        public int numDistinctIslands(int[][] grid) {
            this.grid = grid;
            N = grid.length;
            M = grid[0].length;

            for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j);
                }
            }
            return visited.size();
        }
    }
}
