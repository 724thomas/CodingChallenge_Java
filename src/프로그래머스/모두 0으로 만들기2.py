# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public long solution(int[] b, int[][] edges) {
        long[] a = new long[b.length];
        for (int i=0; i<b.length; i++) a[i] = b[i];
        long sum = 0;
        for (long weight : a) {
            sum += weight;
        }
        if (sum != 0) return -1;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] neighbors = new int[a.length];
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            neighbors[edge[0]]++;
            neighbors[edge[1]]++;
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (neighbors[i] == 1) leaves.add(i);
        }

        long counts = 0;

        for (int i = 0; i < a.length; i++) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                if (neighbors[leaf] == 1) {
                    neighbors[leaf] = 0;

                    int neighbor = graph.get(leaf).iterator().next();

                    neighbors[neighbor]--;
                    if (neighbors[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                    graph.get(neighbor).remove(leaf);

                    a[neighbor] += a[leaf];
                    counts += Math.abs(a[leaf]);
                    a[leaf] = 0;
                }
            }
            leaves = newLeaves;
        }

        return counts;
    }
}

'''



