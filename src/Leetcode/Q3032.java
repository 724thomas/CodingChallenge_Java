package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q3032 {
    class Solution {
        Set<Integer> ans = new HashSet<>();
        int a, b;

        private void dfs(boolean[] visited, int val) {
            if (val >b) return;
            if (a<=val) ans.add(val);

            for (int i=0; i<10; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(visited, val * 10 + i);
                visited[i] = false;
            }
        }

        public int numberCount(int a, int b) {
            this.a = a;
            this.b = b;
            boolean[] visited = new boolean[10];

            if (a<=0 && 0<=b) ans.add(0);

            for (int i=1; i<10; i++) {
                visited[i] = true;
                dfs(visited, i);
                visited[i] = false;
            }
            return ans.size();
        }
    }
}
