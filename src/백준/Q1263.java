// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Q1263 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> tasks = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            tasks.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        } // 걸리는 시간, 끝내야하는 시간

        Collections.sort(tasks, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for (var task : tasks) {
            System.out.println(task[0] + " " + task[1]);
        }

        int startTime = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            startTime = Math.min(startTime, task[1]) - task[0];
        }
        System.out.println(startTime < 0? -1 : startTime);
    }
}
