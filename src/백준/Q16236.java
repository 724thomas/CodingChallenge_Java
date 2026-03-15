// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n ** 4 )

3. 자료구조/알고리즘 :
PriorityQueue, Deque, List
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Shark {
    int row;
    int col;
    int size;
    int eaten;

    public Shark(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.eaten = 0;
    }

    public void eat(Fish fish) {
        row = fish.row;
        col = fish.col;
        eaten++;
        if (eaten == size) {
            size ++;
            eaten = 0;
        }
    }
}

class Fish {
    int row;
    int col;
    int distance;

    public Fish(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Q16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[][] arr;
    static Shark shark;
    static int[][] dirs = new  int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // O(n**2)
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(row[j]);
                arr[i][j] = val;
                if (val == 9) {
                    shark = new Shark(i, j, 2);
                    arr[i][j] = 0;
                }
            }
        }

        // O(n**2) * O(n**2)
        while (true) {
            Fish target = findFish();
            if (target == null) break;

            ans += target.distance;
            arr[target.row][target.col] = 0;
            shark.eat(target);
        }
        System.out.println(ans);
    }

    // O(n**2) + O(log n)
    public static Fish findFish() {
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        PriorityQueue<Fish> pq = new PriorityQueue<>( (a,b) -> {
            if (a.distance != b.distance) return Integer.compare(a.distance, b.distance);
            if (a.row != b.row)  return Integer.compare(a.row, b.row);
            return Integer.compare(a.col, b.col);
        });

        deque.add(new int[]{shark.row, shark.col, 0});
        visited[shark.row][shark.col] = true;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            if (arr[x][y] > 0 && arr[x][y] < shark.size) {
                pq.add(new Fish(x, y, dist));
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx<0||nx>=n||ny<0||ny>=n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] > shark.size) continue;

                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny, dist + 1});
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }
}
