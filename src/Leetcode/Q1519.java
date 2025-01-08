package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1519 {
    class Solution {
        int[] ans;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        String labels;


        public int[] countSubTrees(int n, int[][] edges, String labels) {
            ans = new int[labels.length()];
            this.labels = labels;
            for (int[] e : edges) {
                graph.putIfAbsent(e[0], new ArrayList<>());
                graph.putIfAbsent(e[1], new ArrayList<>());
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }

            dfs(0, -1, labels.charAt(0));
            return ans;
        }

        public int[] dfs(int node, int par, char label) {
            int[] counter = new int[26];

            if (graph.containsKey(node)){
                for (int child : graph.get(node)) {
                    if (child == par) continue;
                    int[] childCounter = dfs(child, node, labels.charAt(child));

                    for (int i=0; i<26; i++) counter[i]+=childCounter[i];
                }
            }

            counter[label-'a']++;
            ans[node] = counter[label - 'a'];
            return counter;
        }
    }
}
