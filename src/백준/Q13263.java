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
import java.util.Arrays;
import java.util.StringTokenizer;

class Q13263 {

    static class Line {
        long m, c;

        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }

        long getValue(long x) {
            return m * x + c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[] prefixSumA = new long[n + 1];

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(stA.nextToken());
            b[i] = Long.parseLong(stB.nextToken());
            prefixSumA[i] = prefixSumA[i - 1] + a[i];
        }

        long[] dp = new long[n + 1];
        Line[] hull = new Line[n + 1];
        int head = 0, tail = 0;

        hull[tail++] = new Line(b[1], -prefixSumA[1] * b[1]);

        for (int i = 2; i <= n; i++) {
            long x = prefixSumA[i];
            while (head + 1 < tail && hull[head].getValue(x) >= hull[head + 1].getValue(x)) {
                head++;
            }
            dp[i] = hull[head].getValue(x);

            Line newLine = new Line(b[i], dp[i] - prefixSumA[i] * b[i]);
            while (head + 1 < tail) {
                Line p1 = hull[tail - 2];
                Line p2 = hull[tail - 1];
                if ((p2.c - p1.c) * (p1.m - newLine.m) <= (newLine.c - p1.c) * (p1.m - p2.m)) {
                    tail--;
                } else {
                    break;
                }
            }
            hull[tail++] = newLine;
        }

        System.out.println(dp[n]);
    }
}