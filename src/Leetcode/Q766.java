package Leetcode;

public class Q766 {
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;

            for (int col = 0; col < cols; col++) {
                int base = matrix[0][col];
                for (int i = 1; i < Math.min(rows, cols - col); i++) {
                    if (matrix[i][col + i] != base) {
                        return false;
                    }
                }
            }

            for (int row = 1; row < rows; row++) {
                int base = matrix[row][0];
                for (int i = 1; i < Math.min(rows - row, cols); i++) {
                    if (matrix[row + i][i] != base) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
