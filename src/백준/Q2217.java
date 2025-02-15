// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
    O( )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Q2217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i=0; i<n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes, (a,b) -> {
            return b-a;
        });

        int ans = 0;
        for (int i=0; i<n; i++) {
            ans = Math.max(ans, ropes.get(i) * (i+1));
        }
        System.out.println(ans);
    }
}
