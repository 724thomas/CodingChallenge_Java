// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Q2232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        var n = Integer.parseInt(input);
        if (n==1){
            System.out.println("1");
            return;
        }

        var arr = new int[n];
        for (var i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (var i=0; i<n; i++) {
            if (i==0) {
                if (arr[i] >= arr[i+1]) {
                    System.out.println(i+1);
                }
            } else if (i==n-1){
                if (arr[i] >= arr[i-1]) {
                    System.out.println(i+1);
                }
            } else {
                if (arr[i] >= arr[i-1] && arr[i] >= arr[i+1]){
                    System.out.println(i+1);
                }
            }
        }
    }
}
