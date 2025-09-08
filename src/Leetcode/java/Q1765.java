package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Q1765 {
    class Solution {
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] board;
        int n, m;

        private void bfs(Deque<int[]> cords) {

            while (!cords.isEmpty()) {
                int[] c = cords.pollFirst();
                int x = c[0], y = c[1];
                int cval = board[x][y];

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m|| cval+1 >= board[nx][ny]) continue;
                    board[nx][ny] = cval+1;
                    cords.add(new int[]{nx, ny});
                }
            }
        }

        public int[][] highestPeak(int[][] isWater) {
            n = isWater.length;
            m = isWater[0].length;
            Deque<int[]> cords = new ArrayDeque<>();
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (isWater[i][j] == 1) {
                    cords.add(new int[]{i, j});
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = Integer.MAX_VALUE;
                }
            }
            board = isWater;

            bfs(cords);
            return board;
        }
    }
}
