package Leetcode;

/*
1. 아이디어 :
문제를 0,0에서 시작하는 두명으로 해석할 수 있습니다.
백트래킹을 통해 두 사람을 동시에 이동시킵니다.
메모이제이션을 통해 중복된 계산을 피합니다.

2. 시간복잡도 :
O( n^5 )

3. 자료구조/알고리즘 :
배열 / 백트래킹
 */

import java.util.Arrays;

public class Q741 {
    class Solution {
        int[][] grid;
        int n;
        int[][][][] dp;
        public int cherryPickup(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            dp = new int[n+1][n+1][n+1][n+1];
            for (int i=0; i<n+1; i++) for (int j=0; j<n+1; j++) for (int k=0; k<n+1; k++) {
                Arrays.fill(dp[i][j][k], -Integer.MAX_VALUE);
            }
            return Math.max(0, backtrack(0,0,0,0));
        }

        public int backtrack(int x1, int y1, int x2, int y2) {
            if (dp[x1][y1][x2][y2] != -Integer.MAX_VALUE) return dp[x1][y1][x2][y2]; // cache
            if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) return -Integer.MAX_VALUE; //out of bound
            if (grid[x1][y1] == -1 || grid[x2][y2] == -1) return -Integer.MAX_VALUE; //blocked

            if (x1 == n-1 && y1 == n-1) return grid[x1][y1];
            if (x2 == n-1 && y2 == n-1) return grid[x2][y2];

            int total = 0;
            total += (x1 == x2 && y1 == y2) ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2];
            total += Math.max(
                    Math.max(backtrack(x1+1,y1,x2+1,y2), backtrack(x1+1,y1,x2,y2+1)),
                    Math.max(backtrack(x1,y1+1,x2+1,y2), backtrack(x1,y1+1,x2,y2+1)) );

            dp[x1][y1][x2][y2] = total;
            return total;
        }
    }
}
