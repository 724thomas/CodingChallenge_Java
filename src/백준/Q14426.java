// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Q14426 {

    static int s;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        int[][] visited = new int[2001][2001];
        for (int i=0; i<=2000; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{1,0,0});
        visited[1][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int curr = current[0];
            int clip = current[1];
            int step = current[2];

            if (curr == s) {
                System.out.println(step);
                return;
            }

            if (visited[curr][curr] == 0 || visited[curr][curr] > step+1) {
                visited[curr][curr] = step+1;
                deque.offer(new int[]{curr, curr, step+1});
            }

            if (clip != 0 && curr + clip <= s && visited[curr+clip][clip] > step+1) {
                visited[curr+clip][clip] = step+1;
                deque.offer(new int[]{curr + clip, clip, step+1});
            }

            if (curr > 0 && visited[curr-1][clip] > step+1) {
                visited[curr-1][clip] = step+1;
                deque.offer(new int[]{curr-1,clip, step+1});
            }
        }
    }
}
