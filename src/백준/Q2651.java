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
import java.util.*;

class Q2651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 정비를 받지 않고 갈 수 있는 최대 거리
        int m = Integer.parseInt(br.readLine()); // 정비소의 개수
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 각 정비소까지의 거리
        int[] inputs2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 각 정비소에서의 정비 시간


        /*

        dp?
        100 30 100 40 50 60
             5  10  4 11  7
        100,0 -> 0, 5 -> 100, 5 -> 140, 5 ->

        0: [100, 0]
        1: [130, 0], [0, 5, 1]
        2: [0, 10, 2],  [100, 5, 1], [0, 15, 1, 2]
        3: [40, 10, 2], [0, 14, 2, 3],  [140, 5, 1], [0, 9, 1, 3], [40, 15, 1, 2], [0, 19, 1, 2, 3]



        100 30 100 40 50 60
             5  10  4 11  7
        마지막 방문 인덱스를 타고가면서 역순
        dp[i] = [최소 시간, 마지막 방문 인덱스]

        dp[0][0] = 0
        dp[1][0] = []  100km
        dp[2][0] = [] 130km

        dp[1][1] = [1] 0km
        dp[2][1] = [1] 30km
        dp[3][1] = [1] 130km

        dp[2][1] =

         */

        boolean[][] reachable = new boolean[m+2][m+2];
        for (int start=0; start<=m; start++) {
            int total = 0;
            for (int end=start+1; end<=m+1; end++) {
                total += inputs[end-1];
                if (total > n) break;
                reachable[start][end] = true;
            }
        }

        int[][] dp = new int[m+2][2]; // 최소 시간, 마지막 방문 인덱스
        for (int i=0; i<=m+1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = -1;
        }
        dp[0][0] = 0;

        for (int curr=1; curr<=m+1; curr++) {
            int cost = curr<=m ? inputs2[curr-1] : 0;
            for (int prev=0; prev<curr; prev++) {
                if (reachable[prev][curr] || dp[prev][0] == Integer.MAX_VALUE) {
                    if (cost + dp[prev][0]< dp[curr][0]) {
                        dp[curr][0] = cost + dp[prev][0];
                        dp[curr][1] = prev;
                    }
                }
            }
        }

        if (dp[m+1][0] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int curr = m+1; curr > 0; curr = dp[curr][1]) {
            if (1<= curr && curr <= m) {
                path.add(curr);
            }
        }
        Collections.reverse(path);
        System.out.println(dp[m+1][0]);
        System.out.println(path.size());
        if (path.size() !=0) {
            StringBuilder sb = new StringBuilder();
            for (int pos : path) sb.append(pos).append(" ");
            System.out.println(sb.toString().trim());
        }
    }
}
