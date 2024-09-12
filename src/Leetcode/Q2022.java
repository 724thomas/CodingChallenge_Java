package Leetcode;

public class Q2022 {
    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            if (original.length != m*n) return new int[][]{};
            int[][] ans = new int[m][n];
            int idx = 0;

            for (int row=0; row<m; row++){
                for (int col=0; col<n; col++){
                    ans[row][col] = original[idx++];
                }
            }

            return ans;
        }
    }
}
