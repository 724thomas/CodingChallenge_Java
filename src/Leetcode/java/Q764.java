package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q764 {
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            // prerfix
            // 6n^2
            int[][] grid = new int[n][n];
            for (var a : grid) Arrays.fill(a, 1); // n*n
            for (int[] m : mines) grid[m[0]][m[1]] = 0; // m

            int[][][] p = new int[n][n][4];
            int sum;
            for (int row=0; row<n; row++) { // 2n*n
                sum = 0;
                for (int col=0; col<n; col++) {
                    sum = (grid[row][col] == 1)? sum+1 : 0;
                    p[row][col][0] = sum;
                }
                sum = 0;
                for (int col=n-1; col>-1; col--) {
                    sum = (grid[row][col] == 1)? sum+1 : 0;
                    p[row][col][1] = sum;
                }
            }

            for (int col = 0; col<n; col++) { // 2n*n
                sum = 0;
                for (int row=0; row<n; row++) {
                    sum = (grid[row][col] == 1)? sum+1 : 0;
                    p[row][col][2] = sum;
                }
                sum = 0;
                for (int row=n-1; row>-1; row--) {
                    sum = (grid[row][col] == 1)? sum+1 : 0;
                    p[row][col][3] = sum;
                }
            }

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
                int k = p[i][j][0];
                k = Math.min(k, p[i][j][1]);
                k = Math.min(k, p[i][j][2]);
                k = Math.min(k, p[i][j][3]);
                ans = Math.max(ans, k);
            }
            return ans;
        }
    }

/*
class Solution {
    int[][] grid;
    int n;
    public int count(int row, int col) {
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        int distance = 0;
        boolean stop = false;

        while (!stop) {
            for (int i=0; i<4; i++) {
                int nx = row + dx[i]*distance, ny = col + dy[i]*distance;
                if (nx<0 || ny<0 || nx >= n || ny >= n || grid[nx][ny] == 0) stop = true;
            }
            if (!stop) distance++;
        }
        return distance;
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) { // 2n^3
        this.n = n;
        grid = new int[n][n];
        for (var a : grid) Arrays.fill(a, 1); // n*n
        for (int[] m : mines) grid[m[0]][m[1]] = 0; // m

        int ans = 0;
        for (int i=0; i<n; i++) for (int j=0; j<n; j++) { //n*n
            ans = Math.max(ans, count(i, j)); //4 * n/2 = 2n
        }
        return ans;
    }
}
*/
}
