package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q892 {
    class Solution {
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
        int n,m ;
        int[][] grid;
        public int countArea(int row, int col) {
            int height = grid[row][col];
            int area = (height == 0) ? 0 : 2; //bottom, top

            for (int i=0; i<4; i++) {
                int nx = row + dx[i], ny = col + dy[i];
                int neighbor = (nx<0 || ny<0 || nx>=n || ny>=m) ? 0 : grid[nx][ny];
                area += Math.max(0, height - neighbor);
            }
            return area;
        }

        public int surfaceArea(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                ans += countArea(i,j);
            }
            return ans;
        }
    }
}
