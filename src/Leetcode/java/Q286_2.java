package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q286_2 {
    class Solution {
        int n, m;
        int INF = 2_147_483_647;
        int[][] rooms;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        boolean[][] visited;
        public void wallsAndGates(int[][] rooms) {
            n = rooms.length;
            m = rooms[0].length;
            this.rooms = rooms;
            visited = new boolean[n][m];

            Deque<int[]> cords = getGateCords();
            calcDistance(cords);
        }

        public Deque<int[]> getGateCords() {
            Deque<int[]> gates = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (rooms[i][j] == 0) {
                        gates.add(new int[]{i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }
            return gates;
        }

        public void calcDistance(Deque<int[]> deque) {
            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int cx = curr[0], cy = curr[1], dis = curr[2];

                for (int i=0; i<4; i++) {
                    int nx = cx + dx[i], ny = cy + dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=m || rooms[nx][ny] == -1) {
                        continue;
                    }
                    if (visited[nx][ny]) continue;
                    rooms[nx][ny] = Math.min(rooms[nx][ny],dis+1);
                    deque.add(new int[]{nx, ny, dis+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
