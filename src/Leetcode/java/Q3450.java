package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3450 {
    class Solution {
        public int maxStudentsOnBench(int[][] students) {
            Map<Integer, Set<Integer>> counter = new HashMap<>();
            int ans = 0;
            for (int[] student : students) {
                int id = student[0], bench = student[1];
                counter.putIfAbsent(bench, new HashSet<>());
                counter.get(bench).add(id);
                ans = Math.max(ans, counter.get(bench).size());
            }
            return ans;
        }
    }
}
