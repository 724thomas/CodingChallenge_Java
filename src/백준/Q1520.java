// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Q1520 {
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int n;
    static int m;
    static int[][] grid;
    static int[][] dp;
    static PriorityQueue<int[]> queue;
    static Set<String> visited;
    static int[] curr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        grid = new int[n][m];
        dp = new int[n][m];
        dp[0][0] = 1;
        for (int i=0; i<n; i++){
            inputs = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                grid[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        visited = new HashSet<>();
        visited.add("0-0");
        queue = new PriorityQueue<>((a,b) -> b[0] - a[0]); // value, x, y
        queue.add(new int[]{grid[0][0], 0, 0});

        while (!queue.isEmpty()) {
            curr = queue.poll();
            int val = curr[0], x = curr[1], y = curr[2];
            int paths = dp[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] >= val) continue;
                dp[nx][ny] += paths;
                String key = nx + "-" + ny;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}






























