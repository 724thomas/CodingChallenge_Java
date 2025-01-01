package Leetcode;

import java.util.Arrays;

public class Q787 {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] cdist = new int[n];
            Arrays.fill(cdist, Integer.MAX_VALUE);
            cdist[src] = 0;
            int[] ndist = Arrays.copyOf(cdist, n);

            for (int i=0; i<k+1; i++) {
                for (int[] e : flights) {
                    int u = e[0], v = e[1], c = e[2];
                    if (cdist[u] == Integer.MAX_VALUE) continue;
                    ndist[v] = Math.min(ndist[v], cdist[u] + c);
                }
                cdist = Arrays.copyOf(ndist, n);
            }

            return cdist[dst] == Integer.MAX_VALUE? -1 : cdist[dst];
        }
    }

}
