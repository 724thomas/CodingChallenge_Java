package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q207 {
    class Solution {
        public boolean canFinish(int n, int[][] prerequisites) {
            int[] degrees = new int[n];
            Map<Integer, List<Integer>> posts = new HashMap<>();
            for (int[] p : prerequisites) {
                int pre = p[0], pos = p[1];
                posts.putIfAbsent(pre, new ArrayList<>());
                posts.get(pre).add(pos);
                degrees[pos]++;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<n; i++) if (degrees[i] == 0) deque.add(i);

            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();
                n--;

                for (int pos : posts.getOrDefault(curr, new ArrayList<>())) {
                    degrees[pos]--;
                    if (degrees[pos]==0) deque.add(pos);
                }
            }
            return n==0;
        }
    }
}
