// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
1000원짜리로 다 합친 후에, 남는 금액만큼 가장 맛이 좋은 날에 메뉴를 변경하면 됩니다.

2. 시간복잡도 :
O( n + mlogm )

3. 자료구조/알고리즘 :
우선순위 큐 / 그리디
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Q23559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int x = Integer.parseInt(inputs[1]);
        int[] costs = {5000, 1000};
        List<int[]> tastes = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String[] taste = br.readLine().split(" ");
            tastes.add(new int[]{Integer.parseInt(taste[0]), Integer.parseInt(taste[1])});
        }

        // 1000원짜리를 먹었을때의합
        int total = 0;
        int left = x- (1000 * n);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for (int[] taste : tastes) {
            total += taste[1];
            pq.add(taste[0]-taste[1]);
        }

        while (left >= 4000 && !pq.isEmpty()) {
            int diff = pq.poll();
            if (diff <= 0) break; // 1000원짜리 먹었을때 맛이 더 나쁜경우
            left -= 4000;
            total += diff;
        }
        System.out.println(total);
    }
}
