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
import java.util.*;

class Q1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static Map<Integer, List<int[]>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(new int[]{end, cost});
        }

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] ); // pos, cost
        pq.add(new int[]{start, 0});
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[start] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currPos = curr[0], currCost = curr[1];
            if (currPos == end) {
                System.out.println(currCost);
                break;
            }

            for (int[] next : map.getOrDefault(currPos, new ArrayList<>())) {
                int nextPos = next[0], nextCost = next[1];
                if (minTime[nextPos] <= currCost + nextCost) continue;
                minTime[nextPos] = currCost + nextCost;
                pq.add(new int[]{nextPos, currCost + nextCost});
            }
        }
    }
}
