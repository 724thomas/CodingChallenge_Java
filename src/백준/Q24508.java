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
import java.util.PriorityQueue;

class Q24508 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = ninputs[0], K = ninputs[1], T = ninputs[2];
        ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long total = 0;
        for (int nadori : ninputs) {
            total += nadori;
        }
        if (total % K != 0) {
            System.out.println("NO");
            return;
        }
        long fullBasket = total / K;
        if (fullBasket == 0) {
            System.out.println("YES");
            return;
        }

        Arrays.sort(ninputs);
        long sum = 0;
        for (int i = N-1; i>=0; i--) {
            sum += ninputs[i];
            fullBasket--;
            if (fullBasket == 0) {
                break;
            }
        }

        if (total - sum <= T) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return;
    }
}
