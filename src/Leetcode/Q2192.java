package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2192 {
    class Solution {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            int[] degrees = new int[n];
            for (int[] e : edges) {
                int u = e[0], v = e[1];
                neighbors.putIfAbsent(u, new ArrayList<>());
                neighbors.get(u).add(v);
                degrees[v]++;
            }

            List<Set<Integer>> ans = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                ans.add(new HashSet<>());
                if (degrees[i]==0) deque.add(i);
            }

            while (!deque.isEmpty()) {
                int curr = deque.poll();

                for (int neighbor : neighbors.getOrDefault(curr, new ArrayList<>())) {
                    ans.get(neighbor).addAll(ans.get(curr));
                    ans.get(neighbor).add(curr);
                    if (--degrees[neighbor] == 0) deque.add(neighbor);
                }
            }

            List<List<Integer>> ans2 = new ArrayList<>();
            for (Set<Integer> set : ans) {
                ans2.add(new ArrayList<>(set));
                Collections.sort(ans2.getLast());
            }

            return ans2;
        }
    }
}
