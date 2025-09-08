package Leetcode.java;

import java.util.Arrays;

public class Q2976 {
    class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            var costs = new long[26][26];
            for (int i=0; i<26; i++){
                Arrays.fill(costs[i], Long.MAX_VALUE);
            }

            for (int i=0; i<cost.length; i++){
                int u = original[i]-'a', v = changed[i]-'a', c = cost[i];
                costs[u][v] = c;
            }

            for (int mid = 0; mid<26; mid++){
                for (int start = 0; start<26; start++) {
                    for (int end=0; end<26; end++) {
                        if (costs[start][mid] == Long.MAX_VALUE || costs[mid][end] == Long.MAX_VALUE) continue;
                        if (costs[start][end] > costs[start][mid] + costs[mid][end]) {
                            costs[start][end] = costs[start][mid] + costs[mid][end];
                        }
                    }
                }
            }

            long ans = 0;
            for (int i=0; i<target.length(); i++) {
                int u = source.charAt(i) - 'a', v = target.charAt(i) - 'a';
                if (u==v) continue;
                if (costs[u][v] == Long.MAX_VALUE){
                    return -1;
                }
                ans += costs[u][v];
            }
            return ans;
        }
    }
}
