package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1926 {
    class Solution {
        int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
        public int nearestExit(char[][] maze, int[] entrance) {
            int n = maze.length, m = maze[0].length;

            boolean[][] visited = new boolean[n][m];
            visited[entrance[0]][entrance[1]] = true;

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{entrance[0], entrance[1], 0});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1], step = c[2];

                if ((x == 0 || x == n-1 || y == 0 || y == m-1) & (x!=entrance[0] || y!=entrance[1])) {
                    return step;
                }

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || maze[nx][ny] == '+') continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny, step+1});
                }
            }
            return -1;
        }
    }
}
