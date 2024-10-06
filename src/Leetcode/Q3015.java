package Leetcode;

import java.util.Arrays;

public class Q3015 {
    class Solution {
        public int[] countOfPairs(int n, int x, int y) {
            int[][] graph = new int[n][n];
            for (int[] g : graph) {
                Arrays.fill(g, 1000);
            }
            for (int i=0; i<n; i++) {
                graph[i][i] = 0;
            }
            for (int i=0; i<n-1; i++){
                graph[i][i+1] = 1;
                graph[i+1][i] = 1;
            }

            graph[x-1][y-1] = 1;
            graph[y-1][x-1] = 1;

            for (int mid = 0; mid<n; mid++) {
                for (int start = 0; start<n; start++) {
                    for (int end=0; end<n; end++) {
                        graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                    }
                }
            }

            int[] ans = new int[n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i==j || graph[i][j] <= 0) continue;
                    ans[graph[i][j]-1]++;
                }
            }
            return ans;
        }
    }
}
