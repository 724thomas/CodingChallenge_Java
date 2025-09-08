package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2872 {
    class Solution {
        Map<Integer, List<Integer>> graph;
        int ans = 0;
        int[] values;
        int k;

        public long dfs (int cur, int par) {
            long total = values[cur];
            for (int child : graph.getOrDefault(cur, new ArrayList<>())) {
                if (child == par) continue;
                total += dfs(child, cur);
            }
            if (total % k == 0) ans++;
            return total;
        }

        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            graph = new HashMap<>();
            this.values = values;
            this.k = k;

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            dfs(0, -1);

            return ans;
        }
    }
}
