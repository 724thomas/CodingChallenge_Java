package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q363 {
    class Solution {

        public int maxSumSubmatrix(int[][] matrix, int k) {
            int n = matrix.length, m = matrix[0].length;

            int[][] prefix = new int[n+1][m+1];

            prefix[1][1] = matrix[0][0];
            for (int row=1; row<n; row++) {
                prefix[row+1][1] = prefix[row][1] + matrix[row][0];
            }
            for (int col=1; col<m; col++) {
                prefix[1][col+1] = prefix[1][col] + matrix[0][col];
            }

            for (int row=1; row<n; row++) for (int col=1; col<m; col++) {
                prefix[row+1][col+1] = prefix[row][col+1] + prefix[row+1][col] - prefix[row][col] + matrix[row][col];
            }

            for (var a : prefix) System.out.println(Arrays.toString(a));

            int ans = Integer.MIN_VALUE;

            for (int row1=1; row1<n+1; row1++) for (int col1=1; col1<m+1; col1++) {
                for (int row2=row1; row2<n+1; row2++) for (int col2=col1; col2<m+1; col2++) {
                    int total = prefix[row2][col2] - prefix[row2][col1-1] - prefix[row1-1][col2] + prefix[row1-1][col1-1];
                    if (total <= k) ans = Math.max(ans, total);
                }
            }
            return ans;
        }
    }
}
