// https://www.acmicpc.net/problem/
package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

class Q17219 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        input = br.readLine();
//        inputs = br.readLine().split(" ");
        ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = ninputs[0];
        int m = ninputs[1];
        HashMap<String, String> cache = new HashMap<>();
        for (int i=0; i<n; i++) {
            inputs = br.readLine().split(" ");
            cache.put(inputs[0], inputs[1]);
        }

        for (int i=0; i<m; i++) {
            System.out.println(cache.get(br.readLine()));
        }
    }
}
