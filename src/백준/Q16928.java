// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
모든 경우의 수를 BFS 탐색
도달한 길을 기록하고, 왔던 길을 다시 돌아가지 않도록 캐싱 값과 비교

2. 시간복잡도 :
O( 6 * 100 )

3. 자료구조/알고리즘 :
Deque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] minCount;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        minCount = new int[101];
        Arrays.fill(minCount, Integer.MAX_VALUE);

        for (int i=0; i<n+m; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            map.put(start, end);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{1, 0}); // pos, count

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            for (int i=1; i<=6; i++) {
                int currPos = curr[0], currCount = curr[1];
                int nextPos = map.getOrDefault(currPos+i, currPos+i);
                if (nextPos > 100) continue;
                if (minCount[nextPos] <= currCount +1) continue;

                minCount[nextPos] = currCount+1;
                deque.add(new int[]{nextPos, currCount+1});
            }
        }

        System.out.println(minCount[100]);
    }
}
