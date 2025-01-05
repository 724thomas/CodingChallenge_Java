package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q947_2 {
    class Solution {
        Map<Integer, Integer> par = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        public int find(int x) {
            if (par.get(x) != x) par.put(x, find(par.get(x)));
            return par.get(x);
        }

        public void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if (ra == rb) return;

            if (size.get(ra) >= size.get(rb)) {
                par.put(rb, ra);
                size.put(ra, size.get(ra)+size.get(rb));
            } else {
                par.put(ra, rb);
                size.put(rb, size.get(ra)+size.get(rb));
            }
        }

        public int removeStones(int[][] stones) {
            for (int[] stone : stones) {
                int x = stone[0];
                int y = stone[1] + 10001;
                par.putIfAbsent(x, x);
                par.putIfAbsent(y, y);
                size.putIfAbsent(x, 1);
                size.putIfAbsent(y, 1);

                union(x, y);
            }

            Set<Integer> visited = new HashSet<>();
            for (int key : par.keySet()) visited.add(find(key));
            return stones.length - visited.size();
        }
    }
}
