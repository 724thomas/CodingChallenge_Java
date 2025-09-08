package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q794 {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            for (var a : board) System.out.println(a);
            int[] bingo = new int[2];
            for (int i=0; i<3; i++) {
                // 가로
                if (board[i].charAt(0) != ' '
                        && board[i].charAt(0) == board[i].charAt(1)
                        && board[i].charAt(1) == board[i].charAt(2)) {
                    bingo[board[i].charAt(0) == 'X'? 0:1] ++;
                    if (bingo[0] == 1 && bingo[1] == 1) return false;
                }
                // 세로
                if (board[0].charAt(i) != ' '
                        && board[0].charAt(i) == board[1].charAt(i)
                        && board[1].charAt(i) == board[2].charAt(i)) {
                    bingo[board[0].charAt(i) == 'X'? 0:1] ++;
                    if (bingo[0] == 1 && bingo[1] == 1) return false;
                }
            }

            if (board[0].charAt(0) != ' '
                    && board[0].charAt(0) == board[1].charAt(1)
                    && board[1].charAt(1) == board[2].charAt(2)) {
                bingo[board[0].charAt(0) == 'X'? 0:1]++;
                if (bingo[0] == 1 && bingo[1] == 1) return false;
            }
            if (board[0].charAt(2) != ' '
                    && board[0].charAt(2) == board[1].charAt(1)
                    && board[1].charAt(1) == board[2].charAt(0)) {
                bingo[board[0].charAt(2) == 'X'? 0:1]++;
                if (bingo[0] == 1 && bingo[1] == 1) return false;
            }

            int[] counter = new int[2]; // x, o
            for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
                if (board[row].charAt(col) == 'X') {
                    counter[0]++;
                } else if (board[row].charAt(col) == 'O') {
                    counter[1]++;
                }
            }

            if (bingo[0] == 1) return counter[0] == counter[1]+1;
            if (bingo[1] == 1) return counter[0] == counter[1];
            return counter[0] == counter[1] || counter[0] == counter[1]+1;
        }
    }
}
