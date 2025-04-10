package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2368 {
    class Solution {
        Set<Integer> restrictedSet = new HashSet<>();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int ans = 0;

        public void dfs(int node, int par) {
            if (restrictedSet.contains(node)) return;

            ans++;
            for (int child : tree.get(node)) {
                if (child == par) continue;
                dfs(child, node);
            }
        }

        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            for (int node : restricted) restrictedSet.add(node);
            for (int[] edge:edges) {
                int s = edge[0], e = edge[1];
                tree.putIfAbsent(s, new ArrayList<>());
                tree.putIfAbsent(e, new ArrayList<>());
                tree.get(s).add(e);
                tree.get(e).add(s);
            }

            dfs(0,-1);

            return ans;
        }
    }
}
