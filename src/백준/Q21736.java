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
import java.util.Arrays;
import java.util.Deque;

class Q21736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static String[][] grid;
    static int[] doYeon = new int[2];

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        grid = new String[n][m];

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            for (int j=0; j<m; j++) {
                grid[i][j] = input.charAt(j)+"";
                if (grid[i][j].equals("I")) doYeon = new int[] {i,j};
            }
        }

        int ans = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{doYeon[0], doYeon[1]});
        grid[doYeon[0]][doYeon[1]] = "X";

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0],  y = curr[1];

            for (int i=0; i<4; i++) {
                int nx = x + dirs[i][0],  ny = y + dirs[i][1];
                if (nx<0||nx>=n||ny<0||ny>=m) continue;
                if (grid[nx][ny].equals("X")) continue;

                if (grid[nx][ny].equals("P")) ans++;
                grid[nx][ny] = "X";
                deque.add(new int[]{nx, ny});
            }
        }


        System.out.println(ans == 0 ? "TT" : ans);

    }
}
