// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Q26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong");

        for (int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            String s1 = inputs[0], s2 = inputs[1];

            if (dancing.contains(s1) || dancing.contains(s2)) {
                dancing.add(s1);
                dancing.add(s2);
            }
        }
        System.out.println(dancing.size());
    }
}
