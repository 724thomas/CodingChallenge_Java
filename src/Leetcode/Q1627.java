package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1627 {
    class Solution {
        int[] par;
        int[] rank;

        public int gcd(int a, int b) {
            if (b==0) return a;
            return gcd(b, a%b);
        }

        public int find(int a) {
            if (par[a] != a) par[a] = find(par[a]);
            return par[a];
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;

            if (rank[ra]>=rank[rb]) {
                par[rb] = ra;
                rank[ra]+=rank[rb];
            } else {
                par[ra] = rb;
                rank[rb]+=rank[ra];
            }
        }

        public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            par = new int[n+1];
            rank = new int[n+1];
            for (int i=0; i<=n; i++) {
                par[i] = i;
                rank[i] = 1;
            }

            for (int i=threshold+1; i<=n; i++) for (int j=i*2; j<=n; j+=i) {
                union(i,j);
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] q:queries) ans.add(find(q[0]) == find(q[1]));
            return ans;
        }
    }
}
