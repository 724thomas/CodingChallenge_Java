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
import java.util.Arrays;
import java.util.Collections;

class Q2141 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long totalPop = 0;

        ArrayList<int[]> cities = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            totalPop += inputs[1];
            cities.add(inputs);
        }
        Collections.sort(cities, (a,b) -> Integer.compare(a[0],b[0]));

        long currPop = 0;
        long target = (totalPop+1)/2;
        for (int i=0; i<n; i++) {
            currPop += cities.get(i)[1];
            if (currPop >= target) {
                System.out.println(cities.get(i)[0]);
                break;
            }
        }
    }
}
