package Leetcode.java;

public class Q1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int ans = 0, imax = 0;
            for (int right=1; right<values.length; right++) {
                ans = Math.max(ans, values[imax] + values[right] + imax - right);
                if (values[imax] +imax  < values[right] + right) imax = right;
            }
            return ans;
        }
    }
}
