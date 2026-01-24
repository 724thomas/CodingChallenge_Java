package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n + n + n )

3. 자료구조/알고리즘 :
Map, List, Deque
 */

import java.util.*;

public class Q210_3 {
    class Solution {
        int[] counter;
        Map<Integer, List<Integer>> map = new HashMap<>();
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            counter = new int[numCourses];
            for (int[] preq : prerequisites) {
                int after = preq[0], before = preq[1];
                counter[after]++;

                List<Integer> afters = map.getOrDefault(before, new ArrayList<>());
                afters.add(after);
                map.put(before, afters);
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<numCourses; i++) {
                if (counter[i] == 0) {
                    deque.add(i);
                }
            }

            int[] ans = new int[numCourses];
            int idx = 0;
            while (!deque.isEmpty()) {
                int before = deque.pollFirst();
                ans[idx++] = before;

                for (int after : map.getOrDefault(before, new ArrayList<>())) {
                    counter[after]--;
                    if (counter[after] == 0) {
                        deque.add(after);
                    }
                }
            }

            return (idx!=numCourses)? new int[]{} : ans;
        }
    }
}
