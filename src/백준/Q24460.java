// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Q24460 {
    public static int get_third(int[][] arr, int length, int row, int col){
        ArrayList<Integer> nums = new ArrayList<>();
        if (length == 1){
            return arr[row][col];
        }
        nums.add(get_third(arr, length/2, row, col));
        nums.add(get_third(arr, length/2, row+length/2, col));
        nums.add(get_third(arr, length/2, row, col+length/2));
        nums.add(get_third(arr, length/2, row+length/2, col+length/2));
        Collections.sort(nums);
        System.out.println(nums);
        return nums.get(1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        System.out.println(get_third(arr, n, 0, 0));
    }
}
