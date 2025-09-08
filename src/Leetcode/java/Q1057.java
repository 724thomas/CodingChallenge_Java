package Leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1057 {
    class Solution {
        public int getDistance(int[] worker, int[] bikes){
            return Math.abs(worker[0] - bikes[0]) + Math.abs(worker[1] - bikes[1]);
        }

        public int[] assignBikes(int[][] workers, int[][] bikes) {
            int[][] w = workers, b = bikes;
            List<int[]> pairs = new ArrayList<>();

            for (int i = 0; i < w.length; i++) for (int j = 0; j < b.length; j++) {
                pairs.add(new int[]{getDistance(w[i], b[j]), i, j});
            }

            Collections.sort(pairs, (x, y) -> {
                if (x[0] != y[0]) return x[0]-y[0];
                if (x[1] != y[1]) return x[1]-y[1];
                return x[2]-y[2];
            });

            int[] ans = new int[w.length];
            Arrays.fill(ans, -1);
            boolean[] visited = new boolean[bikes.length];

            for (int[] pair : pairs) {
                int worker = pair[1];
                int bike = pair[2];

                if (ans[worker] == -1 && !visited[bike]) {
                    ans[worker] = bike;
                    visited[bike] = true;
                }
            }

            return ans;
        }
    }
}
