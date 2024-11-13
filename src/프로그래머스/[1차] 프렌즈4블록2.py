# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int count = 0;

    public void eraseAll(char[][] board, ArrayList<int[]> eraseCords) {
        for (int[] eraseCord : eraseCords) {
            int x = eraseCord[0], y = eraseCord[1];
            for (int i = 0; i<2; i++) {
                for (int j=0; j<2; j++) {
                    if (board[x+i][y+j] != '.'){
                        board[x+i][y+j] = '.';
                        count++;
                    }
                }
            }
        }
    }

    public ArrayList<int[]> getEraseCords(int n, int m, char[][] b) {
        ArrayList<int[]> eraseCords = new ArrayList<>();
        for (int row = 0; row<n-1; row++) {
            for (int col = 0; col<m-1; col++) {
                if (b[row][col] == '.') continue;
                char base = b[row][col];
                if (b[row][col+1] == base && b[row+1][col] == base && b[row+1][col+1] == base) {
                    eraseCords.add(new int[]{row, col});
                }
            }
        }
        return eraseCords;
    }

    public void moveDown(int rows, int cols, char[][] board) {
        for (int col = 0; col<cols; col++) {
            int insertRow = rows-1;
            for (int row=rows-1; row>-1; row--) {
                if (board[row][col] != '.') {
                    board[insertRow][col] = board[row][col];
                    if (insertRow != row) {
                        board[row][col] = '.';
                    }
                    insertRow--;
                }
            }
        }
    }

    public int solution(int n, int m, String[] b) {
        char[][] board = new char[n][m];
        for (int i=0; i<n; i++) board[i] = b[i].toCharArray();

        while (true) {
            ArrayList<int[]> eraseCords = getEraseCords(n, m, board);
            if (eraseCords.size()==0) break;
            eraseAll(board, eraseCords);
            moveDown(n, m, board);
        }
        return count;
    }
}
'''


