package Leetcode.java;

import java.util.HashMap;
import java.util.Map;

public class Q947 {

    public class Solution {
        private Map<Integer, Integer> parent = new HashMap<>();
        private Map<Integer, Integer> rank = new HashMap<>();

        // Find the root of x with path compression
        private int find(int x) {
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        // Union two sets by rank
        private void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if (ra != rb) {
                if (rank.get(ra) > rank.get(rb)) {
                    parent.put(rb, ra);
                } else if (rank.get(ra) < rank.get(rb)) {
                    parent.put(ra, rb);
                } else {
                    parent.put(rb, ra);
                    rank.put(ra, rank.get(ra) + 1);
                }
            }
        }

        public int removeStones(int[][] stones) {
            for (int[] stone : stones) {
                int row = stone[0];
                int col = -stone[1]-1;

                parent.putIfAbsent(row, row);
                parent.putIfAbsent(col, col);
                rank.putIfAbsent(row, 0);
                rank.putIfAbsent(col, 0);

                union(row, col);
            }

            int numComponents = 0;
            for (int key : parent.keySet()) {
                if (find(key) == key) {
                    numComponents++;
                }
            }

            return stones.length - numComponents;
        }
    }
}
