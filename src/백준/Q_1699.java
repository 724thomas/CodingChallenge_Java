// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int i = 1; i*i <= n; i++) {
            int square = i*i;
            for (int j = square; j <= n; j++) {
                arr[j] = Math.min(arr[j], arr[j - square] + 1);
            }
        }

        System.out.println(arr[n]);
    }
}
