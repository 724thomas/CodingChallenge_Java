// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Q1445 {
    private static final char GARBAGE = 'g';
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static char[][] board;
    static int[][][] dist;
    static int[][] nearGarbage;
    static int[] s;
    static int[] e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 예: 한 줄 입력받기
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        nearGarbage = new int[n][m];
        dist = new int[n][m][2];
        for (int row=0; row<n; row++) {
            for (int col=0; col<m; col++) {
                dist[row][col][0] = dist[row][col][1] = Integer.MAX_VALUE;
                if (board[row][col] == GARBAGE) {
                    for (int i=0; i<4; i++) {
                        int nx = row + dx[i], ny = col + dy[i];
                        if (nx>=0 && ny>=0 && nx<n && ny<m && board[nx][ny] == '.') {
                            nearGarbage[nx][ny] = 1;
                        }
                    }
                }
                if (board[row][col] == 'S'){
                    s = new int[]{row, col};
                }
                if (board[row][col] == 'F') {
                    e = new int[]{row, col};
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[2] != b[2]) return a[2]-b[2];
            return a[3]-b[3];
        });

        pq.offer(new int[]{s[0], s[1], 0, 0});
        dist[s[0]][s[1]][0] = 0;
        dist[s[0]][s[1]][1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], gar = curr[2], near = curr[3];

            if (x==e[0] && y==e[1]) {
                System.out.println(gar + " " + near);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx>=0 && ny>=0 && nx <n && ny<m) {
                    int newGar = gar + (board[nx][ny] == GARBAGE ? 1 : 0);
                    int newNear = near + nearGarbage[nx][ny];
                    if (newGar < dist[nx][ny][0] || (newGar == dist[nx][ny][0] && newNear < dist[nx][ny][1])) {
                        dist[nx][ny][0] = newGar;
                        dist[nx][ny][1] = newNear;
                        pq.offer(new int[]{nx, ny, newGar, newNear});
                    }
                }
            }
        }
    }
}
