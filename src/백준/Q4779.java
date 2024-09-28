// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q4779 {

    public static void dfs(char[] arr, int start, int length) {
        if (length == 1) return;

        int seg = length/3;

        for (int i=start+seg; i<start + 2 * seg; i++) {
            arr[i] = ' ';
        }

        dfs(arr, start, seg);
        dfs(arr, start + 2 * seg, seg);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 예: 한 줄 입력받기
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int length = (int) Math.pow(3, n);
            char[] arr = new char[length];
            Arrays.fill(arr, '-');
            dfs(arr, 0, length);
            System.out.println(new String(arr));
        }
    }
}
