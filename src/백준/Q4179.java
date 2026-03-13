// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Q4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int R, C;
    static char[][] grid;
    static int[][] fireDist;
    static int[][] jihoonDist;

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        fireDist = new int[R][C];
        jihoonDist = new int[R][C];

        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jihoonQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fireDist[i][j] = -1;
                jihoonDist[i][j] = -1;
            }
        }

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = input.charAt(j);
                grid[i][j] = ch;

                if (ch == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireDist[i][j] = 0;
                } else if (ch == 'J') {
                    jihoonQ.offer(new int[]{i, j});
                    jihoonDist[i][j] = 0;
                }
            }
        }

        // 1) 불의 도착 시간 계산
        bfsFire(fireQ);

        // 2) 지훈 이동
        int answer = bfsJihoon(jihoonQ);

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    static void bfsFire(Queue<int[]> fireQ) {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (grid[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1) continue;

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }
    }

    static int bfsJihoon(Queue<int[]> jihoonQ) {
        while (!jihoonQ.isEmpty()) {
            int[] cur = jihoonQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 격자 밖으로 나가면 탈출 성공
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    return jihoonDist[x][y] + 1;
                }

                if (grid[nx][ny] == '#') continue;
                if (jihoonDist[nx][ny] != -1) continue;

                int nextTime = jihoonDist[x][y] + 1;

                // 불이 도착하는 칸인데, 불이 더 빨리 오거나 같은 시간에 오면 못 감
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= nextTime) continue;

                jihoonDist[nx][ny] = nextTime;
                jihoonQ.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}
