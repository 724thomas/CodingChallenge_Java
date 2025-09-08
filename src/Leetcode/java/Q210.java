package Leetcode.java;

import java.util.*;

public class Q210 {
    class Solution {
        Map<Integer, ArrayList<Integer>> graph;
        int[] degrees;
        Deque<Integer> queue;
        ArrayList<Integer> ans;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            graph = new HashMap<>();
            degrees = new int[numCourses];
            queue = new LinkedList<>();
            ans = new ArrayList<>();

            for (int[] prerequisite : prerequisites) {
                int prereq = prerequisite[1], course = prerequisite[0];
                graph.putIfAbsent(prereq, new ArrayList<>());
                graph.get(prereq).add(course);
                degrees[course]++;
            }
            for (int i=0; i<numCourses; i++) {
                if (degrees[i] == 0){
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                ans.add(curr);
                if (!graph.containsKey(curr)) continue;
                for (Integer neighbor : graph.get(curr)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            if (ans.size() < numCourses) return new int[]{};

            return ans.stream().mapToInt(i -> i).toArray();
        }
    }
}
