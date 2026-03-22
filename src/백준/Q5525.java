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
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Q5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int size = 0;
        int ans = 0;

        for (int i=1; i<m-1; i++) {
            //OI를 센다
            if (s.charAt(i) == 'O' && s.charAt(i - 1) == 'I' && s.charAt(i + 1) == 'I') {
                size++;

                if (size >= n) {
                    ans++;
                }
                i++;
            } else {
                size = 0;
            }
        }
        System.out.println(ans);
    }
}
