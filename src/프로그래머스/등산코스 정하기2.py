# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    ArrayList<ArrayList<int[]>> neighbors;
    Set<Integer> summitSet;

    public int[] dijkstra(int n, int[] gates) {
        int[] minInts = new int[n+1]; // 각 지점까지 최소 intensitry
        Arrays.fill(minInts, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

        for (int gate: gates){
            pq.add(new int[]{gate, 0});
            minInts[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int currNode = next[0], currInt = next[1];

            if (summitSet.contains(currNode)) continue;
            if (currInt > minInts[currNode]) continue;

            for (int[] neighbor: neighbors.get(currNode)) {
                int nextNode = neighbor[0], nextInt = neighbor[1];
                int newInt = Math.max(currInt, nextInt);

                if (newInt < minInts[nextNode]) {
                    minInts[nextNode] = newInt;
                    pq.add(new int[]{nextNode, newInt});
                }
            }
        }

        int ansSummit = -1;
        int ansInt = Integer.MAX_VALUE;
        for (int summit : summitSet) {
            if (minInts[summit] < ansInt || (minInts[summit] == ansInt && summit < ansSummit)) {
                ansSummit = summit;
                ansInt = minInts[summit];
            }
        }
        return new int[]{ansSummit, ansInt};
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        neighbors = new ArrayList<>();
        for (int i=0; i<=n; i++) neighbors.add(new ArrayList<>());

        for (int[] path: paths) {
            int s = path[0], e = path[1], d = path[2];
            neighbors.get(s).add(new int[]{e, d});
            neighbors.get(e).add(new int[]{s, d});
        }

        summitSet = new HashSet<>();
        for (int summit : summits) summitSet.add(summit);

        return dijkstra(n, gates);
    }
}
'''


