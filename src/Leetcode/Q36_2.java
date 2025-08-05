package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q36_2 {
    class Solution {
        char[][] board;
        public boolean check(int row, int col, char val) {
            for (int i=0; i<9; i++) {
                if (i != col && board[row][i] == val) return false;
                if (i != row && board[i][col] == val) return false;
            }

            int rowSector = row/3 * 3, colSector = col/3 * 3;
            for (int i=0; i<3; i++) for (int j=0; j<3; j++) {
                if (rowSector+i != row && colSector + j != col && board[rowSector+i][colSector+j] == val) return false;
            }
            return true;
        }
        public boolean isValidSudoku(char[][] board) {
            this.board = board;
            for (int i=0; i<9; i++) for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                if (!check(i, j, board[i][j])) return false;
            }

            return true;
        }
    }
}
