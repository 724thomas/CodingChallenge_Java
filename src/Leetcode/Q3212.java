package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3212 {
    class Solution {
        int[][] countX, countY;
        char[][] grid;
        public boolean check(int row, int col) {
            if (countX[row][col] != countY[row][col]) return false;
            if (countX[row][col] == 0) return false;
            return true;
        }
        public int numberOfSubmatrices(char[][] grid) {
            int ans = 0;
            int n = grid.length, m = grid[0].length;
            this.grid = grid;
            countX = new int[n][m];
            countY = new int[n][m];

            countX[0][0] = grid[0][0] == 'X'? 1:0;
            countY[0][0] = grid[0][0] == 'Y'? 1:0;
            if (check(0,0)) ans++;

            for (int i=1; i<n; i++) {
                countX[i][0] = countX[i-1][0] + (grid[i][0] == 'X'? 1:0);
                countY[i][0] = countY[i-1][0] + (grid[i][0] == 'Y'? 1:0);
                if (check(i,0)) ans++;
            }
            for (int i=1; i<m; i++) {
                countX[0][i] = countX[0][i-1] + (grid[0][i] == 'X'? 1:0);
                countY[0][i] = countY[0][i-1] + (grid[0][i] == 'Y'? 1:0);
                if (check(0,i)) ans++;
            }

            for (int i=1; i<n; i++) for (int j=1; j<m; j++) {
                countX[i][j] = countX[i-1][j] + countX[i][j-1] - countX[i-1][j-1] + (grid[i][j] == 'X'? 1:0);
                countY[i][j] = countY[i-1][j] + countY[i][j-1] - countY[i-1][j-1] + (grid[i][j] == 'Y'? 1:0);
                if (check(i,j)) ans++;
            }
            return ans;
        }
    }
}
