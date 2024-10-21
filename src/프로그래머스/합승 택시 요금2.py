# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int[] fare : fares) {
            graph[fare[0]-1][fare[1]-1] = fare[2];
            graph[fare[1]-1][fare[0]-1] = fare[2];
        }
        for (int mid=0; mid<n; mid++){
            for (int start=0; start<n; start++){
                for (int end=0; end<n; end++){
                    if (graph[start][mid] == Integer.MAX_VALUE || graph[mid][end] == Integer.MAX_VALUE) continue;
                    if (graph[start][end] > graph[start][mid] + graph[mid][end]){
                        graph[start][end] = graph[start][mid] + graph[mid][end];
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int mid=0; mid<n; mid++) {
            ans = Math.min(ans, graph[s-1][mid] + graph[mid][a-1] + graph[mid][b-1]);
        }
        return ans;
    }
}


import java.util.*;

public class Solution {
    public int[] dij(int start, int n, ArrayList<ArrayList<int[]>> graph) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currVertex = current[0];
            int currCost = current[1];

            if (currCost > costs[currVertex]) continue;

            for (int[] neighbor : graph.get(currVertex)) {
                int nextVertex = neighbor[0];
                int newCost = currCost + neighbor[1];
                if (newCost < costs[nextVertex]) {
                    costs[nextVertex] = newCost;
                    pq.add(new int[]{nextVertex, newCost});
                }
            }
        }
        return costs;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        s--; a--; b--;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] fare : fares) {
            int u = fare[0] - 1;
            int v = fare[1] - 1;
            int cost = fare[2];
            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }

        int[] costFromS = dij(s, n, graph);
        int[] costFromA = dij(a, n, graph);
        int[] costFromB = dij(b, n, graph);

        int answer = Integer.MAX_VALUE;
        for (int mid = 0; mid < n; mid++) {
            answer = Math.min(answer, costFromS[mid] + costFromA[mid] + costFromB[mid]);
        }
        return answer;
    }


}


'''


