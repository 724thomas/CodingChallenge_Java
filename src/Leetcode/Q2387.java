package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q2387 {
    class Solution {
        public int matrixMedian(int[][] grid) {
            for (var a : grid) System.out.println(Arrays.toString(a));
            int n = grid.length, m = grid[0].length;

            int ans = grid[0][0];
            int[] rowIdx = new int[n];
            for (int i=0; i<=n*m/2; i++) {
                int rowNum = -1;
                int cmax = Integer.MAX_VALUE;
                for (int row=0; row<n; row++) {
                    if (rowIdx[row] == m) continue;
                    int val = grid[row][rowIdx[row]];
                    if (val < cmax) {
                        rowNum = row;
                        cmax = val;
                    }
                }
                rowIdx[rowNum]++;
                ans = cmax;
            }

            return ans;
        }
    }
}
