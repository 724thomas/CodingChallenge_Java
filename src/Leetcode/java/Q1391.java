package Leetcode.java;

/*
1. 아이디어 :
특정 grid에서 갈 수 있는 다음 좌표를 구하고, dfs를 돕니다.

2. 시간복잡도 :
O( n * m * 4 ) // n: grid의 행, m: grid의 열

3. 자료구조/알고리즘 :
3차원 배열 / DFS
 */

import java.util.ArrayList;
import java.util.List;

public class Q1391 {
    class Solution {
        int[][] grid;
        int[][][] connected = {
                { { 0,-1}, { 0, 1} },
                { { 1, 0}, {-1, 0} },
                { { 0,-1}, { 1, 0} },
                { { 0, 1}, { 1, 0} },
                { { 0,-1}, {-1, 0} },
                { { 0, 1}, {-1, 0} }
        };
        boolean[][] visited;
        int n, m;
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0}; // right, left, up, down

        public List<int[]> check(int sx, int sy) {
            List<int[]> newCords = new ArrayList<>();
            int val1 = grid[sx][sy] - 1;
            for (int[] d1 : connected[val1]) {
                int nx = sx + d1[0], ny = sy + d1[1];
                if (nx<0||ny<0||nx>=n||ny>=m) continue;
                int val2 = grid[nx][ny] - 1;

                for (int[] d2 : connected[val2]) {
                    int px = nx + d2[0], py = ny + d2[1];
                    if (px == sx && py == sy) newCords.add(new int[]{nx, ny});
                }
            }
            return newCords;
        }

        public boolean dfs(int x, int y) {
            if (x == n-1 && y == m-1) return true;
            if (visited[x][y]) return false;
            visited[x][y] = true;

            for (int[] cord : check(x, y)) {
                int nx = cord[0], ny = cord[1];
                if (visited[nx][ny]) continue;
                if (dfs(nx,ny)) return true;
            }

            return false;
        }
        public boolean hasValidPath(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
            visited = new boolean[n][m];
            return dfs(0,0);
        }
    }
}
