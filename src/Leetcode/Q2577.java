package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2577 {
    class Solution {
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        public int minimumTime(int[][] grid) {
            if (grid[0][1] >= 2 && grid[1][0] >= 2) return -1;

            int rows = grid.length, cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
            dp[0][0] = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            queue.add(new int[] { 0, 0, 0 });

            while (!queue.isEmpty()) {
                int[] cord = queue.poll();
                int x = cord[0], y = cord[1], time = cord[2];

                if (dp[x][y] < time) continue; // 이미 더 빠른 시간이 기록되었으면 스킵

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;

                    int nval = grid[nx][ny];
                    int waitTime = (time + 1 >= nval) ? 0 : (nval - time - 1 + (nval - time - 1) % 2);
                    int newTime = time + 1 + waitTime;

                    if (newTime < dp[nx][ny]) {
                        dp[nx][ny] = newTime;
                        queue.offer(new int[] { nx, ny, newTime });
                    }
                }
            }

            return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dp[rows - 1][cols - 1];
        }
    }

}
