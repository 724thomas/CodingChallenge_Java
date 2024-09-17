package Leetcode;

import java.util.*;

public class Q3112 {
    class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            var graph = new HashMap<Integer, ArrayList<int[]>>();
            for (var edge : edges) {
                int u = edge[0], v = edge[1], t = edge[2];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(new int[]{v, t});
                graph.get(v).add(new int[]{u, t});
            }

            var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
            pq.offer(new int[]{0, 0}); // time, curr
            var visited = new HashSet<Integer>();
            var ans = new int[n];
            Arrays.fill(ans, -1);

            while (!pq.isEmpty()) {
                var current = pq.poll();
                int total = current[0], curr = current[1];

                if (visited.contains(curr)) continue;
                visited.add(curr);
                ans[curr] = total;

                if (!graph.containsKey(curr)) continue;

                for (var neighborData : graph.get(curr)) {
                    int neighbor = neighborData[0], time = neighborData[1];
                    if (total + time >= disappear[neighbor]) continue;
                    pq.offer(new int[]{total + time, neighbor});
                }
            }
            return ans;
        }
    }

}
