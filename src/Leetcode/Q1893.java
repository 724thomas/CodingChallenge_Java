package Leetcode;

public class Q1893 {
    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            boolean[] range = new boolean[51];
            for (int[] r:ranges) {
                for (int num=r[0]; num<=r[1]; num++) {
                    range[num] = true;
                }
            }

            for (int target=left; target<=right; target++) {
                if (!range[target]) return false;
            }

            return true;
        }
    }
}
