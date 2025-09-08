package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q3249 {
    class Solution {
        Set<Integer> goodNodes = new HashSet<>();
        Map<Integer, List<Integer>> tree = new HashMap<>();

        public int getSize(int curr, int par) {
            int totalSize = 1;

            List<Integer> neighbors = tree.get(curr);
            neighbors.remove(Integer.valueOf(par));

            if (neighbors.size() == 0) {
                goodNodes.add(curr);
                return totalSize;
            }

            boolean isSame = true;
            int baseSize = getSize(neighbors.get(0), curr);
            totalSize += baseSize;

            if (neighbors.size() == 1) {
                goodNodes.add(curr);
                return totalSize;
            }


            for (int i=1; i<neighbors.size(); i++) {
                int neighborSize = getSize(neighbors.get(i), curr);
                totalSize += neighborSize;
                if (baseSize != neighborSize) isSame = false;
            }

            if (isSame) goodNodes.add(curr);
            return totalSize;
        }
        public int countGoodNodes(int[][] edges) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                tree.putIfAbsent(u, new ArrayList<>());
                tree.putIfAbsent(v, new ArrayList<>());
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            tree.get(0).add(-1);
            getSize(0, -1);
            return goodNodes.size();
        }
    }
}
