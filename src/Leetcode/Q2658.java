package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2658 {
    class Solution {
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] grid;
        int n, m;

        public int bfs(int row, int col) {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            int total = grid[row][col];
            grid[row][col] = 0;

            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int x = curr[0], y = curr[1];
                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny <0 || nx>=n || ny>=m || grid[nx][ny] == 0) continue;
                    total += grid[nx][ny];
                    grid[nx][ny] = 0;
                    deque.add(new int[]{nx, ny});
                }
            }
            return total;
        }

        public int findMaxFish(int[][] grid) {
            this.grid=grid;
            n = grid.length;
            m = grid[0].length;

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, bfs(i, j));
            }
            return ans;
        }
    }
}
