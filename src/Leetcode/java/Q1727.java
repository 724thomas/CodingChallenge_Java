package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q1727 {
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
        /*
        [0, 0, 1]
        [1, 1, 1]
        [1, 0, 1]

        [0, 0, 1]
        [1, 1, 2]
        [2, 0, 3]

        [1, 0, 0]
        [2, 1, 1]
        [3, 2, 0]

        */
            int n = matrix.length, m = matrix[0].length;
            int[][] dp = new int[n][m];
            for (int col=0; col<m; col++) {
                dp[0][col] = matrix[0][col];
            }
            for (int col=0; col<m; col++) {
                for (int row = 1; row<n; row++) {
                    dp[row][col] = (matrix[row][col] == 0)? matrix[row][col]: dp[row-1][col]+1;
                }
            }
            int ans = 0;
            for (int row=0; row<n; row++) {
                int[] clone = dp[row].clone();
                Arrays.sort(clone);
                for (int col=0; col<m; col++) {
                    if (clone[col] > 0) {
                        ans = Math.max(ans, (m-col) * clone[col]);
                    }
                }
            }
            return ans;
        }
    }
}
