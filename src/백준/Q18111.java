// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
0부터 256까지의 높이를 기준으로 삼고,
counts 배열(height별 블록 개수)을 이용해서 제거해야 하는 블록 수와 추가해야 하는 블록 수를 계산한다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
배열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, b;
    static int ansTime, ansHeight;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        b = Integer.parseInt(inputs[2]);

        int[] count = new int[257];

        for (int i=0; i<n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(inputs[j]);
                count[h]++;
            }
        }

        ansTime = Integer.MAX_VALUE;
        ansHeight = 0;

        for (int targetHeight=0; targetHeight<=256; targetHeight++) {
            int removed = 0, added = 0;

            for (int h=0; h<=256; h++) {
                if (count[h] == 0) continue;

                if (h > targetHeight) {
                    removed += (h - targetHeight) * count[h];
                } else if (h < targetHeight) {
                    added += (targetHeight - h) * count[h];
                }
            }

            if (removed + b >= added) {
                int time = removed * 2 + added;

                if (time < ansTime || (time == ansTime && targetHeight > ansHeight)) {
                    ansTime = time;
                    ansHeight = targetHeight;
                }
            }
        }
        System.out.println(ansTime + " " + ansHeight);
    }
}
