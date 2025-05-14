package Leetcode;

/*
1. 아이디어 :
row, col을 순회하면서 1을 만나게 되면 bfs를 수행
bfs를 수행하면서 1을 0으로 바꿔준다

2. 시간복잡도 :
O( n*m )

3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q200 {
    class Solution {
        char[][] grid;
        int n, m;
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

        public void bfs(int row, int col) {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1];
                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=m || grid[nx][ny] == '0') continue;
                    grid[nx][ny] = '0';
                    deque.add(new int[]{nx, ny});
                }
            }
        }

        public int numIslands(char[][] grid) {
            this.grid = grid;
            n = grid.length;
            m = grid[0].length;
            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(i, j);
                }
            }
            return ans;
        }
    }
}
