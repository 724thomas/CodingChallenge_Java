package Leetcode;

/*
1. 아이디어 :
그리드의 가장자리가 0이면, 해당 0과 연결되어있는 0도 모두 섬이 될 수 없습니다.
bfs를 통해, 가장 자리 0들을 모두 1로 바꿔줍니다. 남아있는 0들은 모두 섬입니다.
격자를 순회하면서 0을 찾게 되면, 섬+=1해주고, 인접한 0들을 모두 1로 바꿔줍니다.

2. 시간복잡도 :
O( 2n + 2m + n*m )

3. 자료구조/알고리즘 :
배열 / BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1254 {
    class Solution {
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] grid;
        int n, m;

        public void bfs(Deque<int[]> deque) {
            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1];
                grid[x][y] = 1;

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 1) continue;
                    deque.add(new int[]{nx,ny});
                }
            }
        }

        public int closedIsland(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            m = grid[0].length;

            Deque<int[]> deque = new ArrayDeque<>();

            for (int row=0; row<n; row++) {
                if (grid[row][0] == 0) deque.add(new int[]{row, 0});
                if (grid[row][m-1] == 0) deque.add(new int[]{row, m-1});
            }
            for (int col = 0; col < m; col++) {
                if (grid[0][col] == 0) deque.add(new int[]{0, col});
                if (grid[n-1][col] == 0) deque.add(new int[]{n-1, col});
            }
            bfs(deque);

            int ans = 0;
            for (int row=0; row<n; row++) for (int col=0; col<m; col++) {
                if (grid[row][col] == 0) {
                    ans++;
                    deque.add(new int[]{row, col});
                    bfs(deque);
                }
            }

            return ans;
        }
    }
}
