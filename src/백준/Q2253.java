// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
- 2차원 dp를 사용합니다.
- dp[i][j] = i번째 돌에 도달하고, x가 j일때의 최소 점프 횟수
- n이 <=10,000 이므로, j는 약 300 이하.
2. 시간복잡도 :
O( n * 300 )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q2253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Set<Integer> stones = new HashSet<>();
        for (int i=0; i<m; i++) {
            stones.add (Integer.parseInt(br.readLine()));
        }
        if (stones.contains(2)) {
            System.out.println(-1);
            return;
        }

        int[][] dp = new int[n+1][300]; // pos, jump size
        for (int[] pos : dp) Arrays.fill(pos, -1);

        Deque<int[]> deque = new ArrayDeque<>(); // current idx, x jump
        deque.add(new int[]{2, 1});
        dp[2][1] = 1;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int pos = curr[0], x = curr[1];

            for (int nx = x-1; nx <= x+1; nx++) {
                if (nx <= 0) continue;
                if (nx >= 300) continue;

                int nextPos = pos + nx;
                if (nextPos > n || stones.contains(nextPos)) continue;
                if (dp[nextPos][nx] != -1) continue;

                dp[nextPos][nx] = dp[pos][x]+1;

                if (nextPos == n) {
                    System.out.println(dp[nextPos][nx]);
                    return;
                }

                deque.add(new int[]{nextPos, nx});
            }
        }
        System.out.println(-1);
    }
}
