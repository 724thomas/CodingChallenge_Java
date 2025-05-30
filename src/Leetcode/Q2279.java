package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q2279 {
    class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int n = capacity.length;
            int[] diffs = new int[n];
            for (int i=0; i<n; i++) {
                diffs[i] = capacity[i] - rocks[i];
            }
            Arrays.sort(diffs);

            int ans = 0;
            for (int i=0; i<n; i++) {
                if (additionalRocks < diffs[i]) break;
                additionalRocks -= diffs[i];
                ans++;
            }

            return ans;
        }
    }
}
