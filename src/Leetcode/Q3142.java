package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3142 {
    class Solution {
        public boolean satisfiesConditions(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
                if (i != n - 1 && grid[i][j] != grid[i + 1][j]) return false;
                if (j != m - 1 && grid[i][j] == grid[i][j + 1]) return false;
            }
            return true;
        }
    }
}
