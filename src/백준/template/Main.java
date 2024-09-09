// https://www.acmicpc.net/problem/
package 백준.template;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 예: 한 줄 입력받기
        String input = br.readLine();

        // 예: 공백을 기준으로 입력을 나눠서 배열에 저장하기
        String[] inputs = br.readLine().split(" ");

        // 공백을 기준으로 문자열을 나눠서 문자열 배열로 변환
        String[] strArr = input.split(" ");

        // 문자열 배열을 정수형 배열로 변환
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        // 예: 정수로 변환하기
        int a = Integer.parseInt(br.readLine());
        // 배열로 받은 입력을 정수로 변환하기
        int b = Integer.parseInt(inputs[0]);



        // 출력
        // 1차원 배열
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");
        }
        // 2차원 배열
        System.out.println("2차원 배열 출력:");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print(1 + " ");
            }
            System.out.println();
        }

//        static int[][] moveDirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; // 동, 남, 서, 북
//        static int[][] windDirs = {
//                {2, 1, 0, 3}, // value 1
//                {0, 3, 2, 1}, // value 2
//                {3, 2, 1, 0}, // value 3
//                {1, 0, 3, 2}  // value 4
//        };
    }
}
