package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1340 {
    class Solution {
        int N;
        int d;
        int[] arr;
        int[] depths;

        public List<Integer> getNextX(int x) {
            List<Integer> cords = new ArrayList<>();

            for (int i = x + 1; i <= x + d && i < N; i++) {
                if (arr[i] >= arr[x]) break;
                cords.add(i);
            }

            for (int i = x - 1; i >= x - d && i >= 0; i--) {
                if (arr[i] >= arr[x]) break;
                cords.add(i);
            }

            return cords;
        }

        public int dfs(int x) {
            if (depths[x]!=0) return depths[x];

            int maxDepth = 1;

            for (int nextX : getNextX(x)) {
                maxDepth = Math.max(maxDepth, 1 + dfs(nextX));
            }

            depths[x] = maxDepth;
            return maxDepth;
        }

        public int maxJumps(int[] arr, int d) {
            N = arr.length;
            this.d = d;
            this.arr = arr;
            depths = new int[N];

            int ans = 0;
            for (int i=0; i<N; i++) ans = Math.max(ans, dfs(i));

            return ans;

        }
    }
}
