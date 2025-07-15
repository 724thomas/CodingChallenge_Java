package Leetcode;

/*
1. 아이디어 :
Union-find를 사용하여, station들을 그룹으로 묶는다.
각 그룹마다 station들을 우선순위 큐로 관리한다.
쿼리의 타입에 따라, station이 온라인 상태인지 확인하고, 온라인 상태라면 해당 station을 반환하고,
오프라인 상태라면 해당 그룹의 우선순위 큐에서 오프라인 상태가 아닌 가장 작은 station을 반환한다.

2. 시간복잡도 :
O( connections + queries * log(n) )

3. 자료구조/알고리즘 :
우선 순위 큐 / Union-Find
 */

import java.util.*;

public class Q3607 {
    class Solution {
        /*
        union-find?

        */
        int[] par;
        Set<Integer> offline = new HashSet<>();
        int[] groupNum;
        int n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> groupStations = new HashMap<>();

        public int find(int a) {
            if (a!=par[a]) par[a] = find(par[a]);
            return par[a];
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);

            if (ra == rb) return;
            par[ra] = rb;
        }

        public int[] processQueries(int n, int[][] connections, int[][] queries) {
            this.n = n;
            par = new int[n];
            for (int i=0; i<n; i++) par[i] = i;
            groupNum = new int[n];

            for (int[] c : connections) {
                union(c[0]-1, c[1]-1);
            }

            for (int i=0; i<n; i++) {
                int root = find(i);
                groupNum[i] = root;
                groupStations.putIfAbsent(root, new PriorityQueue<>());
                groupStations.get(root).add(i);
            }

            List<Integer> ansList = new ArrayList<>();

            for (int[] q : queries) {
                int type = q[0], station = q[1]-1;
                if (type == 1) {
                    if (!offline.contains(station)) {
                        ansList.add(station+1);
                    } else {
                        int root = find(station);
                        PriorityQueue<Integer> pq = groupStations.get(root);
                        while (offline.contains(pq.peek())) {
                            pq.poll();
                        }

                        ansList.add(pq.isEmpty()? -1 : pq.peek()+1);
                    }
                } else {
                    offline.add(station);
                }
            }

            int[] ans = new int[ansList.size()];
            for (int i=0; i<ansList.size(); i++) ans[i] = ansList.get(i);
            return ans;
        }
    }
}
