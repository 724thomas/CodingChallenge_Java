package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3127 {
    class Solution {
        public boolean check(int row, int col, char[][] grid) {
            int[] counter = new int[2];
            for (int i=row; i<row+2; i++) for (int j=col; j<col+2; j++) {
                if (grid[i][j] == 'B') {
                    counter[0] ++;
                } else {
                    counter[1] ++;
                }
            }
            return counter[0] >=3 || counter[1] >= 3;
        }
        public boolean canMakeSquare(char[][] grid) {
            for (int i=0; i<2; i++) for (int j=0; j<2; j++) {
                if (check(i, j, grid)) return true;
            }
            return false;
        }
    }
}
