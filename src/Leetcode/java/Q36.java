package Leetcode.java;

public class Q36 {
    class Solution {
        public boolean check1(int row, int col, char[][] board) {
            var val = board[row][col];
            for (int i=0; i<9; i++){
                if (i==col) continue;
                if (board[row][i] == val) return false;
            }
            for (int i=0; i<9; i++){
                if (i==row) continue;
                if (board[i][col] == val) return false;
            }

            int x = row/3;
            int y = col/3;
            for (int row2=0; row2<3; row2++) {
                for (int col2=0; col2<3; col2++) {
                    if (row == x*3+row2 && col == y*3+col2) continue;
                    if (board[x*3+row2][y*3+col2] == val) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isValidSudoku(char[][] board) {
            for (int row=0; row<9; row++) {
                for (int col=0; col<9; col++) {
                    if (board[row][col] != '.'){
                        if (!check1(row, col, board)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
