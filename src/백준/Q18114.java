// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Q18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), c = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");

        var arr = new ArrayList<Integer>();
        var set = new HashSet<Integer>();
        for (int i=0; i<n; i++){
            var val = Integer.parseInt(inputs[i]);
            arr.add(val);
            set.add(val);
            if (arr.get(i) == c){
                System.out.println(1);
                return;
            }
        }

        Collections.sort(arr);
        int i =0, j = n-1;
        int weight;

        while (i<j) {
            weight = arr.get(i) + arr.get(j);
            if (weight == c){
                System.out.println(1);
                return;
            } else if (weight > c) {
                j--;
            } else if (weight < c) {
                var remain = c - weight;
                if (set.contains(remain) && remain != arr.get(i) && remain != arr.get(j)) {
                    System.out.println(1);
                    return;
                }
                i++;
            }
        }
        System.out.println(0);
    }
}
