package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1375 {
    class Solution {
        int[] par, size;
        boolean[] visited;
        public int find(int a) {
            if (par[a] != a) par[a] = find(par[a]);
            return par[a];
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;

            par[rb] = ra;
            size[ra]+=size[rb];
        }

        public int numTimesAllBlue(int[] flips) {
            int n = flips.length, ans = 0;
            par = new int[n+3];
            size = new int[n+3];
            for (int i=0; i<n+3; i++) {
                par[i] = i;
                size[i] = 1;
            }
            visited = new boolean[n+3];

            int groups = 0;
            for (int step=1; step<=n; step++) {
                int flip = flips[step-1];
                visited[flip] = true;
                if (visited[flip-1] && visited[flip+1]) {
                    groups--;
                    union(flip, flip-1);
                    union(flip, flip+1);
                } else if (visited[flip-1]) {
                    union(flip, flip-1);
                } else if (visited[flip+1]) {
                    union(flip, flip+1);
                } else {
                    groups++;
                }
                if (groups == 1 && visited[1] && size[find(1)] == step) ans++;
            }

            return ans;
        }
    }
}
