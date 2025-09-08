package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1462 {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            boolean[][] reachable = new boolean[numCourses][numCourses];

            for (int[] p : prerequisites) reachable[p[0]][p[1]] = true;

            for (int mid = 0; mid < numCourses; mid++) {
                for (int start = 0; start<numCourses; start++) {
                    for (int end=0; end<numCourses; end++) {
                        if (reachable[start][mid] && reachable[mid][end]) {
                            reachable[start][end] = true;
                        }
                    }
                }
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] q : queries) {
                ans.add(reachable[q[0]][q[1]]);
            }
            return ans;
        }
    }
}
