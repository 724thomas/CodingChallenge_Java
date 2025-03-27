package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q999 {
    class Solution {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        char[][] board;
        int n, m;

        public int isAttacking(int x, int y) {
            int ans = 0;
            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                while (nx >= 0 && ny >= 0 && nx < n && ny <m) {
                    if (board[nx][ny] == 'p') {
                        ans ++;
                        break;
                    } else if (board[nx][ny] != '.') break;
                    nx += dx[i];
                    ny += dy[i];
                }
            }
            return ans;
        }
        public int numRookCaptures(char[][] board) {
            this.board = board;
            this.n = board.length;
            this.m = board[0].length;

            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (board[i][j] == 'R') {
                    return isAttacking(i,j);
                }
            }
            return -1;
        }
    }
}
