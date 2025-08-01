package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q1376 {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> childs = new HashMap<>();
            for (int child=0; child<n; child++) {
                int par = manager[child];
                childs.putIfAbsent(par, new ArrayList<>());
                childs.get(par).add(child);
            }

            int ans = 0;

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{headID, 0});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int curr = c[0], time = c[1];
                ans = Math.max(ans, time);

                for (int child : childs.getOrDefault(curr, new ArrayList<>())) {
                    deque.add(new int[]{child, time + informTime[curr]});
                }
            }
            return ans;
        }
    }
}
