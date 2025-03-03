package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3459 {
    class Solution {
        int[] dx = new int[]{-1, 1, 1, -1}; //topright, topleft, botright, botleft
        int[] dy = new int[]{1, 1, -1, -1};
        int n, m;
        int[][] grid;
        int[][][][][] straightMemo; //dir, 0/2, changed

        public int dfs(int row, int col, int dir, int target, boolean changed) {
            int nx = row + dx[dir], ny = col + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != target) return 1;

            if (straightMemo[row][col][dir][0][changed? 1:0] != 0) { // visited
                if (!changed) {
                    return Math.max(
                            straightMemo[row][col][dir][0][changed? 1:0],
                            straightMemo[row][col][dir][1][changed? 1:0]
                    );
                } else {
                    return straightMemo[row][col][dir][0][changed? 1:0];
                }
            }

            int straight = 1 + dfs(nx, ny, dir, (target + 2) % 4, changed);
            int change = 0;
            if (!changed) {
                change = 1 + dfs(nx, ny, (dir+1)%4, (target+2) % 4, true);
            }

            straightMemo[row][col][dir][0][changed? 1:0] = straight;
            straightMemo[row][col][dir][1][changed? 1:0] = change;
            return Math.max(straight, change);
        }

        public int lenOfVDiagonal(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
            straightMemo = new int[n][m][4][2][2]; //dir, 0/2

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, 1);
                    ans = Math.max(ans, dfs(i, j, 0, 2, false));
                    ans = Math.max(ans, dfs(i, j, 1, 2, false));
                    ans = Math.max(ans, dfs(i, j, 2, 2, false));
                    ans = Math.max(ans, dfs(i, j, 3, 2, false));
                }
            }
            return ans;
        }
    }
}
