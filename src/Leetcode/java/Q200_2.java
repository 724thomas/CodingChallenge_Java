package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q200_2 {
    class Solution {
        int n;
        int m;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        public int numIslands(char[][] grid) {
            int ans = 0;
            n = grid.length;
            m = grid[0].length;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (grid[i][j] == '1') {
                        bfs(grid, i, j);
                        grid[i][j] = '0';
                        ans++;
                    }
                }
            }
            return ans;
        }

        public void bfs(char[][] grid, int x, int y) {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{x, y});

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int px = curr[0];
                int py = curr[1];

                for (int i=0; i<4; i++) {
                    int nx = px+dx[i];
                    int ny = py+dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m) continue;
                    if (grid[nx][ny] == '0') continue;
                    grid[nx][ny] = '0';
                    deque.add(new int[]{nx, ny});
                }
            }
        }
    }
}
