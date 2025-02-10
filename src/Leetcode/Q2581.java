package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2581 {
    class Solution {
        int[][] edges, guesses;
        int k;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Set<String> guessSet = new HashSet<>();

        int count = 0;
        int ans = 0;

        private void dfs(int curr, int parent) {
            for (int child : tree.get(curr)) {
                if (child==parent) continue;
                if (guessSet.contains(curr + "-" + child)) {
                    count++;
                }
                dfs(child, curr);
            }
        }

        private void reRoot(int curr, int parent, int cnt) {
            if (cnt >= k) ans++;

            for (int child : tree.get(curr)) {
                if (child==parent) continue;
                int currIsRoot = (guessSet.contains(curr + "-" + child)) ? 1 : 0;
                int childIsRoot = (guessSet.contains(child + "-" + curr)) ? 1 : 0;
                reRoot(child, curr, cnt - currIsRoot + childIsRoot);
            }
        }

        public int rootCount(int[][] edges, int[][] guesses, int k) {
            this.edges = edges;
            this.guesses = guesses;
            this.k = k;
            init();

            dfs(0, -1);
            reRoot(0, -1, count);
            return ans;
        }

        private void init() {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                tree.putIfAbsent(u, new ArrayList<>());
                tree.putIfAbsent(v, new ArrayList<>());
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            for (int[] guess : guesses) {
                guessSet.add(guess[0] + "-" + guess[1]);
            }
        }
    }
}
