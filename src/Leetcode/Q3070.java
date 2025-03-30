package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3070 {
    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int n = grid.length, m = grid[0].length;
            int ans = (grid[0][0] <= k)? 1:0;
            for (int i=1; i<n; i++) {
                grid[i][0] += grid[i-1][0];
                if (grid[i][0] <= k) ans++;
            }

            for (int i=1; i<m; i++) {
                grid[0][i] += grid[0][i-1];
                if (grid[0][i] <= k) ans++;
            }

            for (int i=1; i<n; i++) for (int j=1; j<m; j++) {
                grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
                if (grid[i][j] <= k) ans++;
            }

            return ans;
        }
    }
}
