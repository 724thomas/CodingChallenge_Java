package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2556 {
    class Solution {
        int n, m;
        public boolean isPossibleToCutPath(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            if (!check(grid, 0, 0)) return true;
            grid[0][0] = 1;
            return !check(grid, 0, 0);
        }

        private boolean check(int[][] grid, int row, int col) {
            if (row == n - 1 && col == m - 1) return true;
            if (row >= n || col >= m || grid[row][col] == 0) return false;
            grid[row][col] = 0;
            return check(grid, row + 1, col) || check(grid, row, col + 1);
        }
    }
}
