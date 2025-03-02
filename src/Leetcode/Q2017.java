package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2017 {
    class Solution {
        public long gridGame(int[][] grid) {
            int n = 2, m = grid[0].length;
            long[][] prefix = new long[2][m+1];


            for (int i=0; i<2; i++) for (int j=1; j<m+1; j++) {
                prefix[i][j] = prefix[i][j-1] + grid[i][j-1];
            }

            long ans = Long.MAX_VALUE;
            for (int i=0; i<m; i++) {
                long bestTop = prefix[0][m] - prefix[0][i+1];
                long bestBot = prefix[1][i];
                ans = Math.min(ans, Math.max(bestTop, bestBot));
            }
            return ans;
        }
    }
}
