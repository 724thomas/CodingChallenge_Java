package Leetcode;

/*
1. 아이디어 :
다익스트라, dp로 풀 수 있습니다.
2차원 배열(graph)을 초기화하여, i지점부터 갈 수 있는 경로들과 거리를 저장합니다.
2차원 배열(counter)를 n개의 지점과 2개의 정보(거리, 경로수)를 저장하기 위해 초기화합니다.
counter[0]은 0, 1로 초기화하는데, 0번째 지점까지 갈 수 있는 최선의 방법은 0의 거리이고 1가지입니다.
우선순위큐를 통해, 길이가 가장 적은 노드부터 탐색합니다.
큐가 비어있을때까지 반복하면서, 현재 노드에서 갈 수 있는 노드들을 탐색합니다.
- 현재 노드까지의 거리와 다음 노드까지의 거리를 더 한 값이, 다음 노드에 저장되어있는 총 거리보다 적으면 갱신하고, 경로수를 1로 초기화합니다.
- 값이 같다면 다음 노드의 경로수에 현재 노드의 경로수를 더합니다.


2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
우선순위큐, 2차원 배열 / 다익스트라, dp
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q1976 {
    class Pair {
        int node;
        long distance;

        Pair(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    class Solution {
        int MOD = 1_000_000_007;

        public int countPaths(int n, int[][] roads) {
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
            int m = roads.length;
            for (int i = 0; i < m; i++) {
                graph.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
                graph.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
            }

            long[][] counter = new long[n][2]; // distance, counter
            for (int i = 0; i < n; i++) counter[i] = new long[]{Long.MAX_VALUE, 0};
            counter[0] = new long[]{0, 1};

            PriorityQueue<Pair> pq = new PriorityQueue<>((Pair1, Pair2) -> Long.compare(Pair1.distance, Pair2.distance));
            pq.add(new Pair(0, 0));

            while (pq.size() != 0) {
                Pair c = pq.poll();
                int currNode = c.node;
                long currDistance = c.distance;

                for (Pair neighbor : graph.get((int) currNode)) {
                    long distance = neighbor.distance;
                    int nextNode = neighbor.node;

                    long totalDistance = currDistance + distance;
                    if (totalDistance < counter[nextNode][0]) {
                        counter[nextNode][0] = totalDistance;
                        counter[nextNode][1] = counter[currNode][1];
                        pq.add(new Pair(nextNode, totalDistance));
                    } else if (totalDistance == counter[nextNode][0]) {
                        counter[nextNode][1] = (counter[nextNode][1] + counter[currNode][1]) % MOD;
                    }
                }
            }

            return (int)counter[n - 1][1];
        }
    }
}
