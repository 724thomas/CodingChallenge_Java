# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

public class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Map<Integer, Integer> sourcesMap = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            sourcesMap.put(sources[i], i);
        }

        int[] ans = new int[sources.length];
        Arrays.fill(ans, -1);

        Set<Integer> visited = new HashSet<>();
        visited.add(destination);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{destination, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currNode = current[0];
            int time = current[1];

            if (sourcesMap.containsKey(currNode)) {
                int idx = sourcesMap.get(currNode);
                ans[idx] = time;
            }

            for (int neighbor : graph.get(currNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, time + 1});
                }
            }
        }
        return ans;
    }
}

'''

from collections import defaultdict, deque
def solution(n, roads, sources, destination):
    graph = defaultdict(list)
    for u, v in roads:
        graph[u].append(v)
        graph[v].append(u)
    sources_map = {sources[i]:i for i in range(len(sources))}
    ans = [-1] * len(sources)

    visited = set()
    visited.add(destination)
    queue = deque()
    queue.append((destination, 0))

    while queue:
        curr, time = queue.popleft()
        if curr in sources_map:
            idx = sources_map[curr]
            ans[idx] = time

        for neighbor in graph[curr]:
            if neighbor in visited:
                continue
            visited.add(neighbor)
            queue.append((neighbor, time+1))


    return ans
