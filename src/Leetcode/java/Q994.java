package Leetcode.java;

/*
1. 아이디어 :
썩은 애들을 기준으로 BFS

2. 시간복잡도 :
O( n * m ) = 100

3. 자료구조/알고리즘 :
BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int[] dx = new int[]{0,0,1,-1};
            int[] dy = new int[]{1,-1,0,0};

            Deque<int[]> queue = new ArrayDeque<>();
            int fresh = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                        grid[i][j] = 0;
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            int minutes = 0;

            while (!queue.isEmpty() && fresh > 0) {
                int size = queue.size();
                minutes++;

                for (int s = 0; s < size; s++) {
                    int[] cur = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (grid[nx][ny] != 1) continue;

                        grid[nx][ny] = 2;
                        fresh--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            return fresh == 0 ? minutes : -1;
        }
    }
}
