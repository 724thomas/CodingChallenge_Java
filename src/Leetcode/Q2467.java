package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2467 {
    class Solution {
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        List<Integer> bobRoute;
        Set<Integer> visited;
        Set<Integer> bobVisited = new HashSet<>();

        int[] amount;
        int bob;
        int[] bobTime;
        public void findBobRoute(int idx, List<Integer> curr) {
            if (idx == bob) {
                bobRoute = new ArrayList<>(curr);
                return;
            }

            for (int neighbor: neighborMap.get(idx)) {
                if (visited.contains(neighbor)) continue;
                curr.add(neighbor);
                visited.add(neighbor);

                findBobRoute(neighbor, curr);

                curr.remove(curr.size()-1);
                visited.remove(neighbor);
            }
        }

        public int getIncome(int node, int aliceTime) {
            int bobArrive = bobTime[node];
            if (bobArrive == -1 || aliceTime < bobArrive) return amount[node];
            if (aliceTime == bobArrive) return amount[node] / 2;
            return 0;
        }

        public int bfs() {
            int ans = Integer.MIN_VALUE;
            Deque<int[]> deque = new ArrayDeque<>(); //pos, income, time;
            deque.add(new int[]{0,0,0});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int pos = c[0], income = c[1], time = c[2];

                List<Integer> neighbors = neighborMap.get(pos);
                boolean isLeaf = true;
                int totalIncome = income + getIncome(pos, time);
                for (int neighbor : neighbors) {
                    if (visited.contains(neighbor)) continue;
                    visited.add(neighbor);
                    deque.add(new int[]{neighbor, totalIncome, time+1});
                    isLeaf = false;
                }

                if (isLeaf) ans = Math.max(ans, totalIncome);
            }
            return ans;
        }

        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            this.bob = bob;
            this.amount = amount;
            for (int[] e : edges) {
                int u = e[0], v = e[1];
                neighborMap.putIfAbsent(u, new ArrayList<>());
                neighborMap.putIfAbsent(v, new ArrayList<>());
                neighborMap.get(u).add(v);
                neighborMap.get(v).add(u);
            }

            // Bob 루트 계산
            visited = new HashSet<>();
            visited.add(0);
            findBobRoute(0, new ArrayList<>(List.of(0)));
            Collections.reverse(bobRoute);
            // System.out.println(bobRoute);

            // Bob 시간 생성
            int n = amount.length;
            bobTime = new int[n];
            Arrays.fill(bobTime, -1);
            for (int t=0; t < bobRoute.size(); t++) {
                int node = bobRoute.get(t);
                bobTime[node] = t;
            }

            return bfs();
        }
    }
}
