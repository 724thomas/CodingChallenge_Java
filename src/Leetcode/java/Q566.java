package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int[][] ans = new int[r][c];
            int n = mat.length, m = mat[0].length;
            if (r*c != n*m) return mat;

            int row = 0, col = 0;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                ans[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    row++;
                    col=0;
                }
            }
            return ans;
        }
    }
}
