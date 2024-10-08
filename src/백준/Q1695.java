// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1695 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numinputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[n];

        for (int start=n-2; start>-1; start--){
            int prev = 0;
            for (int end = start+1; end<n; end++) {
                int temp = dp[end];
                if (numinputs[start] == numinputs[end]){
                    dp[end] = prev;
                } else {
                    dp[end] = Math.min(dp[end], dp[end-1]) + 1;
                }
                prev = temp;
            }
        }
        System.out.println(dp[n-1]);
    }
}
