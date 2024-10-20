// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q1748 {
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = 0, len = 1, start = 1;
        for (long i=1; i<n-1; i*= 10) ans += (Math.min(n, start * 10 - 1) - start + 1) * len++;
        System.out.println(ans);
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = 0;
        long len = 1;
        long start = 1;
        while (start < n+1) {
            long end = start * 10 - 1;
            end = Math.min(end, n);
            ans += (end - start + 1) * len;
            len++;
            start *= 10;
        }
        System.out.println(ans);

        /*
         n = 120
        len = 1
        start = 1
        end = 9
        ans += (9 - 1 + 1) * 1 = 9

        len = 2
        start = 10
        end = 100 - 1 = 99
        ans += (99 - 10 + 1) * 2 = 180

        len = 3
        start = 100
        end = min(1000 - 1, 120) = 120
        ans += (120 - 100 + 1 ) * 3 = 63
          */
    }
}
