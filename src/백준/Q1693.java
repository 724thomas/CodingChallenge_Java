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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Q1693 {

    static int N;
    static final int MAX_COLORS = 20;
    static ArrayList<Integer>[] adj;
    static long[][] dp; // dp[node][color]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        dp = new long[N + 1][MAX_COLORS + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1, 0);

        long minCost = Long.MAX_VALUE;
        for (int c = 1; c <= MAX_COLORS; c++) {
            minCost = Math.min(minCost, dp[1][c]);
        }

        System.out.println(minCost);
        br.close();
    }

    public static void dfs(int curr, int parent) {
        for (int child : adj[curr]) {
            if (child != parent) {
                dfs(child, curr);
            }
        }

        for (int c = 1; c <= MAX_COLORS; c++) { // 현재 노드를 c 색상으로 칠하는 경우
            long costSumForChildren = 0;
            for (int child : adj[curr]) {
                if (child != parent) {
                    long minChildCost = Long.MAX_VALUE;
                    for (int childColor = 1; childColor <= MAX_COLORS; childColor++) {
                        if (c != childColor) {
                            minChildCost = Math.min(minChildCost, dp[child][childColor]);
                        }
                    }
                    costSumForChildren += minChildCost;
                }
            }
            dp[curr][c] = c + costSumForChildren;
        }
    }
}