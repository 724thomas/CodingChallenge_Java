# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    HashMap<Integer, ArrayList<Integer>> furthest;
    HashMap<Integer, ArrayList<Integer>> graph;

    public int bfs(){
        int furthestDist = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{1, 0}); // node, distance

        while (!deque.isEmpty()){
            int[] curr = deque.poll();
            int node = curr[0], distance = curr[1];

            for (Integer neighbor : graph.get(node)){
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                deque.offer(new int[]{neighbor, distance+1});
                furthest.putIfAbsent(distance+1, new ArrayList<>());
                furthest.get(distance+1).add(neighbor);
                furthestDist = Math.max(furthestDist, distance+1);
            }
        }
        return furthestDist;
    }

    public int solution(int n, int[][] edge) {
        furthest = new HashMap<>();
        graph = new HashMap<>();
        for (int[] e : edge) {
            int u = e[0], v = e[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return furthest.get(bfs()).size();
    }
}

'''


