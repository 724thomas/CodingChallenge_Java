package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q1091 {
    class Solution {
        int n;
        int[][] grid, distances;
        int[] dx = { 0,  1,  1,  1,  0, -1, -1, -1};
        int[] dy = { 1,  1,  0, -1, -1, -1,  0,  1};

        public int bfs() {
            Deque<int[]> deque = new ArrayDeque<>(); //row, col, dis
            deque.addLast(new int[]{0,0,1});

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1], dis = curr[2];
                if (x==n-1 && y==n-1) return dis;

                for (int i=0; i<8; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (grid[nx][ny] == 1 || distances[nx][ny] <= dis+1) continue;
                    distances[nx][ny] = dis+1;
                    deque.add(new int[]{nx, ny, dis+1});
                }
            }
            return -1;
        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            n = grid.length;
            if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
            this.grid = grid;
            distances = new int[n][n];
            for (int i=0; i<n; i++) Arrays.fill(distances[i], n*n+1);
            return bfs();
        }
    }
}
