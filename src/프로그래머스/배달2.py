# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int N, int[][] roads, int K) {
        int[][] distances = new int[N+1][N+1];
        for (int i=1; i<=N; i++) Arrays.fill(distances[i], Integer.MAX_VALUE);

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int[] distance1 = new int[N+1];
        Arrays.fill(distance1, Integer.MAX_VALUE);

        for (int[] road : roads) {
            int s = road[0], e = road[1], d = road[2];
            graph.putIfAbsent(s, new HashSet<>());
            graph.putIfAbsent(e, new HashSet<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
            distances[s][e] = Math.min(distances[s][e], d);
            distances[e][s] = Math.min(distances[e][s], d);
        }

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0}); //city, distnace
        distance1[1] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int c = curr[0], d = curr[1];
            if (distance1[c] < d || d > K) continue;
            distance1[c] = d;
            for (int neighbor : graph.get(c)) {
                queue.add(new int[]{neighbor, d + distances[c][neighbor]});
            }
        }

        int ans = 0;
        for (int d : distance1) if (d <=K) ans++;
        return ans;
    }
}
'''



