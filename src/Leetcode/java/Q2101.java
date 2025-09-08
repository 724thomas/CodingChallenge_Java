package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2101 {
    class Solution {
        int n;
        Map<Integer, List<Integer>> childs = new HashMap<>();

        public long getDistance(int[] b1, int[] b2){
            long dx = b1[0] - b2[0];
            long dy = b1[1] - b2[1];
            return dx*dx + dy*dy;
        }

        public int bfs(int start) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            deque.add(start);
            visited[start] = true;
            int ans = 0;
            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();
                ans++;
                for (int child : childs.getOrDefault(curr, new ArrayList<>())) {
                    if (visited[child]) continue;
                    visited[child] = true;
                    deque.add(child);
                }
            }
            return ans;
        }

        public int maximumDetonation(int[][] bombs) {
            n = bombs.length;

            for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
                long dist = getDistance(bombs[i], bombs[j]);

                if ((long) bombs[i][2] * bombs[i][2] >= dist) {
                    childs.putIfAbsent(i, new ArrayList<>());
                    childs.get(i).add(j);
                }
                if ((long) bombs[j][2] * bombs[j][2] >= dist) {
                    childs.putIfAbsent(j, new ArrayList<>());
                    childs.get(j).add(i);
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, bfs(i));
            }

            return ans;
        }
    }

}
