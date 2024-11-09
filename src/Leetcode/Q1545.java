package Leetcode;

public class Q1545 {
    class Solution {
        public char dfs(int totalLength, int k) {
            // System.out.println(totalLength + " " + k);
            int mid = totalLength / 2;
            if (totalLength == 1) return '0';
            if (k == mid) return '1';
            if (k < mid) return dfs(mid, k);
            return dfs(mid, totalLength - 1 - k) == '0' ? '1' : '0';
        }
        public char findKthBit(int n, int k) {
            int totalLength = 0;
            for (int i=0; i<n; i++) totalLength = totalLength * 2 + 1;
            return dfs(totalLength, k-1);
        }
    }
}
