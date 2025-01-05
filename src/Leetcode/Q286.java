package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q286 {
    class Solution {
        int INF = 2147483647;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int N, M;
        int[][] rooms;

        public void bfs(int row, int col) {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col, 0});
            rooms[row][col] = 0;

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1], d = c[2];

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny <0 || nx >=N || ny >= M) continue;
                    if (rooms[nx][ny] == -1 || rooms[nx][ny] <= d+1) continue;
                    rooms[nx][ny] = d+1;
                    deque.add(new int[]{nx, ny, d+1});
                }
            }
        }

        public void wallsAndGates(int[][] rooms) {
            N = rooms.length;
            M = rooms[0].length;
            this.rooms = rooms;

            for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
                if (rooms[i][j] == 0) bfs(i,j);
            }
        }
    }
}
