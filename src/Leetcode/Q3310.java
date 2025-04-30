package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q3310 {
    class Solution {
        int[] par;

        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            par = new int[n];
            for (int i=0; i<n; i++) par[i] = i;

            Map<Integer, List<Integer>> invokes = new HashMap<>();
            for (int[] i : invocations) {
                invokes.putIfAbsent(i[0], new ArrayList<>());
                invokes.get(i[0]).add(i[1]);
            }

            Deque<Integer> deque = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            visited[k] = true;
            deque.add(k);

            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();

                for (int neighbor : invokes.getOrDefault(curr, new ArrayList<>())) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    deque.add(neighbor);
                    union(curr, neighbor);
                }
            }

            for (int i=0; i<n; i++) {
                int curr = find(i);
                if (visited[curr]) continue;
                for (int neighbor : invokes.getOrDefault(curr, new ArrayList<>())) {
                    int rootNeighbor = find(neighbor);
                    visited[rootNeighbor] = false;
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if (!visited[find(i)]) ans.add(i);
            }

            return ans;
        }

        public int find(int a) {
            if (par[a] != a) par[a] = find(par[a]);
            return par[a];
        }

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return true;

            if (ra > rb) {
                par[rb] = ra;
            } else {
                par[ra] = rb;
            }
            return false;
        }
    }
}
