package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q308 {
    class NumMatrix {
        int[][] prefixSum;
        int n, m;
        int[][] matrix;
        boolean dirty = true;
        public NumMatrix(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;
            prefixSum = new int[n+1][m+1];
            this.matrix = matrix;
        }

        public void update(int row, int col, int val) {
            matrix[row][col] = val;
            dirty = true;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dirty) calculate();
            return prefixSum[row2+1][col2+1]
                    - prefixSum[row1][col2+1]
                    - prefixSum[row2+1][col1]
                    + prefixSum[row1][col1];
        }

        public void calculate() {
            prefixSum[1][1] = matrix[0][0];
            for (int i=1; i<n; i++) {
                prefixSum[i+1][1] = prefixSum[i][1] + matrix[i][0];
            }
            for (int j=1; j<m; j++) {
                prefixSum[1][j+1] = prefixSum[1][j] + matrix[0][j];
            }

            for (int i=1; i<n; i++) {
                for (int j=1; j<m; j++) {
                    prefixSum[i+1][j+1] = matrix[i][j] + prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j];
                }
            }
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);

 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]]

 03 03 04 08 10
 08 14 18 24 27
 09 17 21 28 36
 13
 14
 */
}
