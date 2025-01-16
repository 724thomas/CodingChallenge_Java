package Leetcode;

public class Q1582 {
    class Solution {
        int[] visited = new int[202];

        public int numSpecial(int[][] mat) {
            int ans = 0;
            for (int i=0; i<mat.length; i++) for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    visited[i]++;
                    visited[j+101]++;
                }
            }

            for (int i=0; i<mat.length; i++) for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == 1 && visited[i] == 1 &&visited[j+101] == 1) ans++;
            }
            return ans;
        }
    }
}
