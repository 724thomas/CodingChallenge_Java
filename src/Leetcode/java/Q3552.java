package Leetcode.java;

/*
1. 아이디어 :
그리디하게 풀어야 하는 문제. (다익스트라도 풀림)
알파벳에 따른 좌표를 저장.
bfs를 돌면서 해당 좌표에 도달했을 때
- 알파벳이면, 반대쪽 웜홀에서 나오고, 해당 길을 제거. 이때, 큐의 맨 앞에 둬야함
- 상하좌우로 이동할 수 있는 좌표를 큐에 넣음.

2. 시간복잡도 :
O( 2*n*m  )

3. 자료구조/알고리즘 :
- 해시맵 / 그리디 bfs
 */

import java.util.*;

public class Q3552 {
    class Solution {
        int n, m;
        Map<Character, List<int[]>> holes = new HashMap<>();
        String[] matrix;
        int[][] costs;
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

        public int minMoves(String[] matrix) {
            n = matrix.length;
            m = matrix[0].length();
            this.matrix = matrix;
            costs = new int[n][m];
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                char c = matrix[i].charAt(j);
                costs[i][j] = Integer.MAX_VALUE;
                if (c == '#' || c == '.') continue;
                holes.putIfAbsent(c, new ArrayList<>());
                holes.get(c).add(new int[]{i, j});
            }
            return daijkstra();
        }

        public int daijkstra() {
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{0,0,0});
            costs[0][0] = 0;

            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int x = curr[0], y = curr[1], cost = curr[2];
                if (costs[x][y] < cost) continue;
                if (x==n-1 && y==m-1) return cost;

                char key = matrix[x].charAt(y);
                if (holes.containsKey(key)) {
                    for (int[] cord : holes.get(key)) {
                        int nx = cord[0], ny = cord[1];
                        if (x == nx && y == ny) continue;
                        if (costs[nx][ny] > cost) {
                            costs[nx][ny] = cost;
                            deque.addFirst(new int[]{nx, ny, cost});
                        }
                    }
                    holes.remove(key);
                }

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m||matrix[nx].charAt(ny)=='#') continue;
                    if (costs[nx][ny] > cost+1) {
                        costs[nx][ny] = cost+1;
                        deque.add(new int[]{nx, ny, cost+1});
                    }
                }
            }
            return -1;
        }
    }
}
