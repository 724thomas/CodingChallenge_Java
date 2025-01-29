package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q2965 {
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int[] ans = new int[2]; //repeated, missing
            int total = 0;
            int total2 = 0;
            Set<Integer> visited = new HashSet<>();

            for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
                int num = grid[i][j];
                total += num;
                total2 += n*i + j + 1;
                if (!visited.add(num)) ans[0] = num;
            }

            ans[1] = (total > total2)? ans[0] - (total - total2) : ans[0] + (total2 - total);
            return ans;

        /*
        1+2+3+4 = 10
        1+2+3+2 = 8

        1+2+3+4+5+6+7+8+9 = 45
        1+2+3+4+6+7+8+9+9 = 49

        */
        }
    }
}
