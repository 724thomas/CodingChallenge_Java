package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q3033 {
    class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {
            int n =matrix.length, m = matrix[0].length;
            for (int col=0; col<m; col++) {
                List<Integer> rowNums = new ArrayList<>();
                int cmax = 0;
                for (int row = 0; row<n; row++) {
                    if (matrix[row][col] == -1) rowNums.add(row);
                    cmax = Math.max(cmax, matrix[row][col]);
                }
                for (int row : rowNums) {
                    matrix[row][col]=cmax;
                }
            }
            return matrix;
        }
    }
}
