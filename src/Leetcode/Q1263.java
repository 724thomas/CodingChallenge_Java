package Leetcode;

/*
1. 아이디어 :
상자와 사람의 위치를 기록합니다.

상자를 움직일 수 있는 좌표들을 구합니다.
상자를 밀기 위한 좌표로 사람이 움직일 수 있는지 확인합니다.
중복 방지를 위해 visited 4차원 배열을 사용합니다.
2. 시간복잡도 :
O( n^2 * m^2 * 4 * 4)  // n: 행의 개수, m: 열의 개수

3. 자료구조/알고리즘 :
4차원 배열 / BFS
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q1263 {
    class Solution {
        int n, m;
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        char[][] grid;

        public List<int[]> boxMovableCords(int bx, int by, int px, int py) { // n * m * 4
            List<int[]> cords = new ArrayList<>();
            for (int i=0; i<4; i++) {
                int nbx = bx + dx[i], nby = by + dy[i];
                if (nbx<0||nby<0||nbx>=n||nby>=m||grid[nbx][nby] == '#') continue; // box in grid
                int npx = bx - dx[i], npy = by - dy[i];
                if (npx<0||npy<0||npx>=n||npy>=m||grid[npx][npy] == '#') continue; // push pos in grid
                if (!personMoveable(px, py, npx, npy, bx, by)) continue; // n * m
                cords.add(new int[]{nbx, nby});
            }
            return cords;
        }

        public boolean personMoveable(int sx, int sy, int ex, int ey, int bx, int by) { // n * m
            if (sx<0 || sy<0 || sx>=n || sy>=m) return false;
            if (ex<0 || ey<0 || ex>=n || ey>=m) return false;
            Deque<int[]> deque = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][m];
            deque.add(new int[]{sx, sy});
            visited[sx][sy] = true;

            while (!deque.isEmpty()) {
                int[] c = deque.poll();
                int x = c[0], y = c[1];
                if (x == ex && y == ey) return true;
                for (int i=0; i<4; i++) {
                    int nx = x+dx[i], ny = y + dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;
                    if (grid[nx][ny] == '#' || (nx == bx && ny == by)) continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
            return false;
        }

        public int minPushBox(char[][] grid) {
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
            boolean[][][][] visited = new boolean[n][m][n][m];

            int[] T = {-1,-1}, B = {-1, -1}, S = {-1,-1};
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) { // n * m
                if (grid[i][j] == 'T') T = new int[]{i,j};
                else if (grid[i][j] == 'B') B = new int[]{i,j};
                else if (grid[i][j] == 'S') S = new int[]{i,j};
            }
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{B[0], B[1], S[0], S[1], 0});

            while (!deque.isEmpty()) { // n * m * 4
                int[] c= deque.poll();
                int bx = c[0], by = c[1], px = c[2], py = c[3], push = c[4];
                if (bx == T[0] && by == T[1]) return push;
                for (int[] cord : boxMovableCords(bx, by, px, py)) { // n * m * 4
                    if (visited[cord[0]][cord[1]][bx][by]) continue;
                    visited[cord[0]][cord[1]][bx][by] = true;
                    deque.add(new int[]{cord[0], cord[1], bx, by, push+1});
                }
            }

            return -1;
        }
    }
}
