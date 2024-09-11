// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Q_20182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int a = Integer.parseInt(inputs[2]);
        int b = Integer.parseInt(inputs[3]);
        int c = Integer.parseInt(inputs[4]);

        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i=0; i<m; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[0], y[0]));
        pq.offer(new int[]{0, 0, a}); // cmax, money, curr

        int[] min_cost = new int[n+1];
        for (int i=1; i<=n; i++) {
            min_cost[i] = Integer.MAX_VALUE;
        }
        min_cost[a] = 0;

        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            int cmax = temp[0];
            int ccost = temp[1];
            int curr = temp[2];

            if (curr == b) {
                System.out.println(min_cost[curr]);
                return;
            }
            if (min_cost[curr] < cmax) continue;

            for (int[] neighbor : graph.get(curr)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];

                if (ccost + nextCost <= c && min_cost[nextNode] > Math.max(min_cost[curr], nextCost)) {
                    min_cost[nextNode] = Math.max(min_cost[curr], nextCost);
                    pq.add(new int[]{min_cost[nextNode], ccost + nextCost, nextNode});
                }
            }

        }
        System.out.println(-1);
    }
}
