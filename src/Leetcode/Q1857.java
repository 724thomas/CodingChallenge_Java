package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q1857 {
    class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            Map<Integer, List<Integer>> childs = new HashMap<>();
            int[] degree = new int[n]; //detect cycle
            int visited = 0;

            for (int[] edge: edges) {
                childs.putIfAbsent(edge[0], new ArrayList<>());
                childs.get(edge[0]).add(edge[1]);
                degree[edge[1]]++;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                if (degree[i]==0) deque.add(i);
            }

            int[][] counter = new int[n][26];
            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();
                counter[curr][colors.charAt(curr)-'a']++;
                visited++;

                for (int child: childs.getOrDefault(curr, new ArrayList<>())){
                    for (int i=0; i<26; i++) {
                        counter[child][i] = Math.max(counter[curr][i], counter[child][i]);
                    }

                    degree[child]--;
                    if (degree[child] == 0) deque.add(child);
                }
            }

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=0; j<26; j++) {
                ans = Math.max(ans, counter[i][j]);
            }

            if (visited < n) return -1;
            return ans;
        }
    }
}
