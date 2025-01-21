package Leetcode;

public class Q3289 {
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int idx = 0;
            int[] ans = new int[2];
            boolean[] visited = new boolean[101];
            for (int num:nums) {
                if (visited[num]) {
                    ans[idx++] = num;
                    if (idx==2) return ans;
                } else {
                    visited[num] = true;
                }
            }
            return ans;
        }
    }
}
