// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q1189 {
    private static final char BLOCK = 'T';
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    static int n, m, k;
    static char[][] board;
    static boolean[][] visited;

    static int dfs(int x, int y, int step) {
        if (x == 0 && y == m - 1) {
            return step == k ? 1 : 0;
        }

        visited[x][y] = true;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] != BLOCK) {
                count += dfs(nx, ny, step + 1);
            }
        }

        visited[x][y] = false;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(dfs(n - 1, 0, 1));
    }
}
