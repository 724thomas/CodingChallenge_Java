package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q59 {
    class Solution {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        public int[][] generateMatrix(int n) {
            int[][] grid = new int[n][n];
            int dir = 0;

            int x = 0, y = 0;
            for (int i=1; i<=n*n; i++) {
                grid[x][y] = i;
                int nx = x+dx[dir], ny = y+dy[dir];
                if (nx<0 || ny<0 || nx >= n || ny>=n || grid[nx][ny] != 0) {
                    dir = (dir+1)%4;
                    nx = x+dx[dir];
                    ny = y+dy[dir];
                }
                x = nx;
                y = ny;
            }
            return grid;
        }
    }
}
