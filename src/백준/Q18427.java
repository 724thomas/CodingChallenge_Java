// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q18427 {
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int h = Integer.parseInt(inputs[2]);

        ArrayList<ArrayList<Integer>> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> blocks = new ArrayList<>();
            inputs = br.readLine().split(" ");
            for (String input : inputs) blocks.add(Integer.parseInt(input));
            students.add(blocks);
        }

        int[] dp = new int[h + 1];
        dp[0] = 1;
        for (var blocks : students) {
            for (int height = h; height >= 0; height--) {
                for (int block : blocks) {
                    if (height - block >= 0) dp[height] = (dp[height] + dp[height - block]) % MOD;
                }
            }
        }
        System.out.println(dp[h]);
    }
}
