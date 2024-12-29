package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1136 {
    class Solution {
        Map<Integer, List<Integer>> afterCourses = new HashMap<>();
        int[] prereqs;
        public int minimumSemesters(int n, int[][] relations) {
            int ans = 0;
            prereqs = new int[n];
            for (int[] r : relations) {
                int pre = r[0]-1, pos = r[1]-1;
                prereqs[pos]++;
                afterCourses.putIfAbsent(pre, new ArrayList<>());
                afterCourses.get(pre).add(pos);
            }

            List<Integer> curr = new ArrayList<>();
            for (int i=0; i<n; i++) if (prereqs[i]==0) curr.add(i);

            while (!curr.isEmpty()) {
                ans++;
                List<Integer> post = new ArrayList<>();

                for (int preCourse : curr) {
                    if (!afterCourses.containsKey(preCourse)) continue;
                    for (int afterCourse : afterCourses.get(preCourse)) {
                        prereqs[afterCourse]--;
                        if (prereqs[afterCourse] == 0) post.add(afterCourse);
                    }
                }
                curr = post;
            }

            for (int i=0; i<n; i++) if (prereqs[i] != 0) return -1;
            return ans;
        }
    }
}
