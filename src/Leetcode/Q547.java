package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q547 {
    class Solution {
        int[] par;
        public int find(int a) {
            if (a != par[a]) par[a] = find(par[a]);
            return par[a];
        }
        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            par[ra] = par[rb];
        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            par = new int[n];
            for (int i=0; i<n; i++) par[i]=i;
            for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
                if (isConnected[i][j]==1) union(i, j);
            }
            int roots = 0;
            for (int i=0; i<n; i++) if (par[i] == i) roots++;
            return roots;
        }
    }
}
