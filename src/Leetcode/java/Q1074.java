package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n^2 * m^2 )

3. 자료구조/알고리즘 :

 */

public class Q1074 {
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length;
            // for (var a : matrix) System.out.println(Arrays.toString(a));

            int[][] prefix = new int[n+1][m+1];
            prefix[1][1] = matrix[0][0];
            for (int i=1; i<n; i++) {
                prefix[i+1][1] = prefix[i][1] + matrix[i][0];
            }
            for (int i=1; i<m; i++) {
                prefix[1][i+1] = prefix[1][i] + matrix[0][i];
            }

            for (int i=1; i<n; i++) for (int j=1; j<m; j++) {
                prefix[i+1][j+1] = prefix[i][j+1] + prefix[i+1][j] - prefix[i][j] + matrix[i][j];
            }


            // for (var a : prefix) System.out.println(Arrays.toString(a));

            int count = 0;
            for (int x1 = 0; x1<n; x1++) {
                for (int y1 = 0; y1<m; y1++) {
                    for (int x2 = x1; x2<n; x2++) {
                        for (int y2 = y1; y2<m; y2++) {
                            int total = prefix[x2+1][y2+1]
                                    - prefix[x1][y2+1]
                                    - prefix[x2+1][y1]
                                    + prefix[x1][y1];
                            if (total == target) count++;
                        }
                    }
                }
            }
            return count;
        }
    }
}
