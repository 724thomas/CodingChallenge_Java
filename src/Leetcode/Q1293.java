package Leetcode;

/*
1. 아이디어 :
3차원 dp로 풀었습니다.
큐를 통해서 방문한 곳들을 유지하고, 최소값에 대한 큐의 저장된 것들만 연산하기 위해서 큐에 저장된 step과 dp의 저장된 dp이 다르면 continue

2. 시간복잡도 :
O( n * m * k )

3. 자료구조/알고리즘 :
배열 / dp
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q1293 {
    class Solution {
        int[][][] dp;
        int n, m;
        int k;
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};

        public int shortestPath(int[][] grid, int k) {
            n = grid.length;
            m = grid[0].length;
            this.k = k;
            dp = new int[n][m][k+1];
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{0,0,k,0}); //row, col, left k, queueStep
            dp[0][0][k] = 0;

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1], lk = c[2], qStep = c[3];
                int minStep = dp[x][y][lk];
                if (qStep != minStep) continue;

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    int nk = (grid[nx][ny] == 1)? lk-1 : lk;
                    if (nk <0 ) continue;

                    if (dp[nx][ny][nk] <= qStep+1) continue;
                    deque.add(new int[]{nx, ny, nk, qStep+1});
                    dp[nx][ny][nk] = qStep+1;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int steps : dp[n-1][m-1]) {
                ans = Math.min(ans, steps);
            }

            return (ans==Integer.MAX_VALUE)? -1 : ans;
        }
    }
}
