package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2246 {
    class Solution {
        Map<Integer, List<Integer>> children = new HashMap<>();
        String s;
        int ans = 0;

        public int[] dfs(int curr) {
            char currChar = s.charAt(curr);

            int longest = 0;
            int longer = 0;

            int same = 0;

            for (int child : children.getOrDefault(curr, new ArrayList<>())) {
                int[] childDfs = dfs(child);
                int childDiff = childDfs[0];
                int childSame = childDfs[1];

                // diff
                if (currChar != s.charAt(child)) {
                    if (longest < childDiff) {
                        longer = longest;
                        longest = childDiff;
                    } else if (longer < childDiff) {
                        longer = childDiff;
                    }

                    // same
                } else {
                    same = Math.max(same, childSame+1);
                }
            }
            ans = Math.max(ans, longest + longer + 1);
            return new int[]{longest + 1, same};
        }

        public int longestPath(int[] parent, String s) {
            this.s=s;

            for (int i=0; i<parent.length; i++) {
                int par = parent[i];
                children.putIfAbsent(par, new ArrayList<>());
                children.get(par).add(i);
            }
            // System.out.println(children);

            dfs(0);
            return ans;
        }
    }
}
