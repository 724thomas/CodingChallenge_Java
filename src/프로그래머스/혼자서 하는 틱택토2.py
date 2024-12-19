# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    String[] board;

    public int checkNegDiag(char turn) {
        for (int i=0; i<3; i++) {
            if (board[2-i].charAt(i) != turn) return 0;
        }
        return 1;
    }

    public int checkPosDiag(char turn) {
        for (int i=0; i<3; i++) {
            if (board[i].charAt(i) != turn) return 0;
        }
        return 1;
    }

    public int checkCol(int col, char turn) {
        for (int row=0; row<3; row++) {
            if (board[row].charAt(col) != turn) return 0;
        }
        return 1;
    }

    public int checkRow(int row, char turn) {
        for (int col=0; col<3; col++) {
            if (board[row].charAt(col) != turn) return 0;
        }
        return 1;
    }

    public int countBingo(char turn) {
        int bingo = 0;
        for (int i=0; i<3; i++) {
            bingo += checkRow(i, turn);
            bingo += checkCol(i, turn);
        }
        bingo += checkPosDiag(turn);
        bingo += checkNegDiag(turn);
        return bingo;
    }

    public boolean check() {
        int OBingoCount = countBingo('O');
        int XBingoCount = countBingo('X');

        int Ocount = 0;
        int Xcount = 0;
        for (int i=0; i<3; i++) for (int j=0; j<3; j++) {
            if (board[i].charAt(j) == 'O') {
                Ocount++;
            } else if (board[i].charAt(j) == 'X') {
                Xcount++;
            }
        }
        if (Ocount < Xcount || Ocount > Xcount + 1) return false;

        if (OBingoCount > 0 && XBingoCount>0) return false;
        if (OBingoCount > 0 && Ocount != Xcount +1) return false;
        if (XBingoCount > 0 && Ocount != Xcount) return false;
        return true;
    }

    public int solution(String[] board) {
        this.board = board;
        return check()? 1 : 0;
    }
}
'''



