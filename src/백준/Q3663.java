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

class Q3663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int toTarget(Character c) {
        int increase = c -'A';
        int decrease = 'Z' - c + 1;
        return Math.min(increase, decrease);
//        int decrease =
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int j=0; j<n; j++) {
            String input = br.readLine();
            int m = input.length();

            int ans = 0;
            for (int i=0; i<m; i++) {
                ans += toTarget(input.charAt(i));
            }

            int minMove = m - 1;

            for (int moveRight = 0; moveRight < m; moveRight++) {
                int next = moveRight+1;
                while (next < m && input.charAt(next) == 'A') {
                    next++;
                }

                minMove = Math.min(minMove, moveRight + moveRight + (m-next));
                minMove = Math.min(minMove, moveRight + (m-next) + (m-next));
            }
            System.out.println(ans + minMove);
        }
    }
}
