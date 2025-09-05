package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1722 {

    class Solution {
        int[] par, sz;

        private int find(int a) {
            if (a != par[a]) par[a] = find(par[a]);
            return par[a];
        }

        private void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            // (선택) union by size
            if (sz[ra] < sz[rb]) { int t = ra; ra = rb; rb = t; }
            par[rb] = ra;
            sz[ra] += sz[rb];
        }

        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            int n = source.length;
            par = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) { par[i] = i; sz[i] = 1; }

            for (int[] e : allowedSwaps) union(e[0], e[1]);

            // 1) 루트별로 source 값의 빈도 맵 구성
            Map<Integer, Map<Integer, Integer>> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int r = find(i);
                freq.computeIfAbsent(r, k -> new HashMap<>())
                        .merge(source[i], 1, Integer::sum);
            }

            // 2) target를 보며 같은 컴포넌트에서 매칭 가능하면 소진, 아니면 해밍 +1
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int r = find(i);
                Map<Integer, Integer> m = freq.get(r);
                int v = target[i];
                int c = m.getOrDefault(v, 0);
                if (c == 0) {
                    ans++;
                } else {
                    if (c == 1) m.remove(v);
                    else m.put(v, c - 1);
                }
            }
            return ans;
        }
    }

}
