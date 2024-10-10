// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1074 {
    static int ans = 0;
    static int[] target;
    public static int calc(int length, int x, int y, int row, int col) {
        if (length == 1){
            return 0;
        }

        int size = length/2;
        if (row < x + size && col < y + size) {
            return calc(size, x, y, row, col);
        } else if ( row < x+ size && col >= y + size) {
            return size * size + calc(size, x, y+size, row, col);
        } else if ( row >= x+size && col < y+ size) {
            return 2 * size * size + calc(size, x+size, y, row, col);
        } else {
            return 3 * size * size + calc(size, x+size, y+size, row, col);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(calc((int)Math.pow(2, inputs[0]), 0, 0, inputs[1], inputs[2]));
    }
}
