package Leetcode.java;

public class Q3237 {
    class Solution {
        public int[] simulationResult(int[] windows, int[] queries) {
            int[] ans = new int[windows.length];
            boolean[] visited = new boolean[windows.length+1];

            int idx = 0;
            for (int i = queries.length-1; i>-1; i--) {
                int q = queries[i];
                if (visited[q]) continue;
                visited[q] = true;
                ans[idx++] = q;
            }
            for (int i=0; i<windows.length; i++) {
                int w = windows[i];
                if (visited[w]) continue;
                visited[w] = true;
                ans[idx++] = w;
            }

            return ans;
        }
    }
}
