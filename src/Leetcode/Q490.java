package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q490 {
    class Solution {
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int[][] maze;
        int N, M;
        boolean[][] visited;

        public List<int[]> getNextCords(int x, int y) {
            List<int[]> cords = new ArrayList<>();
            for (int i=0; i<4; i++) {
                int nx = x, ny = y;
                while (nx >=0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (nx == x && ny == y) continue;
                cords.add(new int[]{nx-dx[i], ny-dy[i]});
            }

            return cords;
        }

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            this.maze = maze;
            N = maze.length;
            M = maze[0].length;
            visited = new boolean[N][M];

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(start);

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1];

                for (int[] cord : getNextCords(x, y)) {
                    int nx = cord[0], ny = cord[1];
                    if (nx == destination[0] && ny == destination[1]) return true;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }


            return false;
        }
    }
}
