package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q79 {
    class Solution {
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        char[][] board;
        String word;
        boolean[][] visited;
        int n, m;

        public boolean dfs(int row, int col, int idx) {
            if (board[row][col] != word.charAt(idx)) return false;
            if (idx == word.length()-1) return true;


            for (int i=0; i<4; i++) {
                int nx = row + dx[i], ny = col + dy[i];
                if (nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (dfs(nx, ny, idx+1)) {
                    return true;
                }
                visited[nx][ny] = false;
            }
            return false;
        }

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            n = board.length;
            m = board[0].length;
            visited = new boolean[n][m];
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(i, j, 0)) return true;
                    visited[i][j] = false;
                }
            }
            return false;
        }
    }
}
