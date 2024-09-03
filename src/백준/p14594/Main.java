// https://www.acmicpc.net/problem/
package 백준.p14594;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] par;

    static int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            par[rb] = ra;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
        }

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for (int j = x; j < y; j++) {
                union(j, j + 1);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
