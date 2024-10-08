// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Q11663 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[] points = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] segment = br.readLine().split(" ");
            int start = Integer.parseInt(segment[0]);
            int end = Integer.parseInt(segment[1]);

            int startIdx = lowerBound(points, start);

            int endIdx = upperBound(points, end);

            sb.append(endIdx - startIdx).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static int lowerBound(int[] points, int target) {
        int low = 0, high = points.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (points[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int[] points, int target) {
        int low = 0, high = points.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (points[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}