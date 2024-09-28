// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class Q15651 {
    public static void backtrack(int[] curr, int depth, int n, int m, StringBuilder sb) {
        if (depth == m){
            for (int i=0; i<m; i++) {
                sb.append(curr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            curr[depth] = i;
            backtrack(curr, depth+1,n, m, sb);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);

        StringBuilder sb = new StringBuilder();
        backtrack(new int[m], 0, n, m, sb);

        System.out.println(sb.toString());
    }
}
