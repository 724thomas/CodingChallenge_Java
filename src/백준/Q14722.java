// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
- dp + bfs

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
Deque / bfs, dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Q14722 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 1}, dy = {1, 0};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<int[]> cities = new ArrayList<>();
        for (int i=0; i<n; i++) {
            cities.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }

//        for (var a : cities) System.out.println(Arrays.toString(a));
        int[][] dp = new int[n][n];
        dp[0][0] = cities.get(0)[0] == 0 ? 1 : 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        Deque<int[]> deque = new ArrayDeque<>(); //x, y, milkCount;
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] c = deque.poll();
            int x = c[0], y = c[1];
            int milkCount = dp[x][y];
            int needType = milkCount % 3;

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= n || ny >= n) continue;
                dp[nx][ny] = Math.max(dp[nx][ny], milkCount + (needType == cities.get(nx)[ny] ? 1 : 0));
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny});
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
