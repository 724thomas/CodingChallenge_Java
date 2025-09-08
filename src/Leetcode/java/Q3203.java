package Leetcode.java;

import java.util.*;

public class Q3203 {
    class Solution {
        public int[] getFurthest(int N, int node, Map<Integer, List<Integer>> pars) {
            int fDist = 0;
            int fNode = node;

            boolean[] visited = new boolean[N];
            visited[node] = true;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{node, 0});

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int par = curr[0], dist = curr[1];
                fDist = dist;
                fNode = par;

                if (!pars.containsKey(par)) continue;
                for (int child: pars.get(par)) {
                    if (visited[child]) continue;
                    visited[child]=true;
                    deque.addLast(new int[]{child, dist+1});
                }
            }
            return new int[]{fNode, fDist};
        }

        public Map<Integer, List<Integer>> makeTree(int[][] edge) {
            Map<Integer, List<Integer>> par = new HashMap<>();
            for (int[] e : edge) {
                int p = e[0], c = e[1];
                par.putIfAbsent(p, new ArrayList<>());
                par.putIfAbsent(c, new ArrayList<>());
                par.get(p).add(c);
                par.get(c).add(p);
            }
            return par;
        }


        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            int N = edges1.length+1;
            int M = edges2.length+1;
            Map<Integer, List<Integer>> Npar = makeTree(edges1);
            Map<Integer, List<Integer>> Mpar = makeTree(edges2);

            int[] tree1;
            tree1 = getFurthest(N, 0, Npar);
            tree1 = getFurthest(N, tree1[0], Npar);

            int[] tree2;
            tree2 = getFurthest(M, 0, Mpar);
            tree2 = getFurthest(M, tree2[0], Mpar);

            int longestDist1 = tree1[1]+1;
            int longestDist2 = tree2[1]+1;
            return Math.max(longestDist1-1, Math.max(longestDist2-1, (int)longestDist1/2 + (int)longestDist2/2 + 1));
        }
    }
}
