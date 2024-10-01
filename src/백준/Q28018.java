// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Q28018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        Arrays.fill(arr,0);
        for (int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");
            arr[Integer.parseInt(temp[0])] ++;
            arr[Integer.parseInt(temp[1])+1]--;
        }

        for (int i=1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }

        int m = Integer.parseInt(br.readLine());
        String[] times = br.readLine().split(" ");
        for (int i=0; i<times.length; i++){
            System.out.println(arr[Integer.parseInt(times[i])]);
        }
    }
}
