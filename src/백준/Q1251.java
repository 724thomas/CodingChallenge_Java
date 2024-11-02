// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q1251 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        int n = input.length();

        for (int i = 1; i<n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                String p1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String p2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                String p3 = new StringBuilder(input.substring(j, n)).reverse().toString();

                String candidate = p1 + p2 + p3;
                if (candidate.compareTo(input) < 0) {
                    input = candidate;
                }
            }
        }
        System.out.println(input);
    }
}
