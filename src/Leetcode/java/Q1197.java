package Leetcode.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1197 {
    class Solution {
        int[] dx = new int[]{1,1,-1,-1,2,2,-2,-2};
        int[] dy = new int[]{2,-2,-2,2,1,-1,-1,1};

        public int minKnightMoves(int a, int b) {
            int X = a+300, Y = b+300;
            boolean[][] visited = new boolean[601][601];
            visited[300][300] = true;

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{300,300,0});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1], d = c[2];
                if (x==X && y==Y) return d;

                for (int i=0; i<8; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx <0 || ny<0 || nx >= 601 || ny >=601) continue;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx,ny,d+1});
                }
            }

            return -1;

        }
    }
}
