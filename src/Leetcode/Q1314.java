package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1314 {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int n = mat.length, m = mat[0].length;
            int[][] ps = new int[n+1][m+1];

            for (int i=0; i<n; i++) {
                ps[i+1][1] = ps[i][1] + mat[i][0];
            }

            for (int j=0; j<m; j++) {
                ps[1][j+1] = ps[1][j] + mat[0][j];
            }

            for (int i=1; i<n; i++) {
                for (int j=1; j<m; j++) {
                    ps[i+1][j+1] = mat[i][j] + ps[i][j+1] + ps[i+1][j] - ps[i][j];
                }
            }

            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                int minX = Math.max(0, i-k), minY = Math.max(0, j-k);
                int maxX = Math.min(n, i+1+k), maxY = Math.min(m, j+1+k);
                mat[i][j] = ps[maxX][maxY] + ps[minX][minY]
                        - ps[minX][maxY] - ps[maxX][minY];
            }

            return mat;
        }
    }
}
