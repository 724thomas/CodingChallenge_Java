package Leetcode;

import java.util.Arrays;

public class Q3074 {
    class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            int ans = 0;
            Arrays.sort(capacity);
            int total = 0;
            for (int a : apple) total += a;
            for (int i=capacity.length-1; i>-1; i--) {
                total -= capacity[i];
                ans++;
                if (total <= 0) return ans;
            }

            return -1;
        }
    }
}
