package Leetcode.java;

/*
1. 아이디어 :
degrees 배열을 만들어서 각 과목의 선행과목 개수를 저장한다.

2. 시간복잡도 :
O( n + p ) // n: 과목 개수, p: 선행과목 개수

3. 자료구조/알고리즘 :
큐 / bfs
 */

import java.util.*;

public class Q210_2 {
    class Solution {
        public int[] findOrder(int n, int[][] prerequisites) {
            Map<Integer, List<Integer>> aftCourses = new HashMap<>();
            int[] degrees = new int[n];

            for (int[] p : prerequisites) {
                int aft = p[0], pre = p[1];
                degrees[aft]++;
                aftCourses.putIfAbsent(pre, new ArrayList<>());
                aftCourses.get(pre).add(aft);
            }

            int[] ans = new int[n];
            int idx = 0;

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<n; i++) if (degrees[i] == 0) deque.add(i);

            while (!deque.isEmpty()) {
                int c = deque.pollFirst();
                ans[idx++] = c;

                for (int aftCourse : aftCourses.getOrDefault(c, new ArrayList<>())) {
                    degrees[aftCourse]--;
                    if (degrees[aftCourse] == 0) deque.add(aftCourse);
                }
            }

            return idx==n ? ans : new int[]{};
        }
    }
}
