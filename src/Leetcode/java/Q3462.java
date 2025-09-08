package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3462 {
    class Solution {
        public long maxSum(int[][] grid, int[] limits, int k) {
            int n = grid.length, m = grid[0].length;
            for (int[] g: grid) Arrays.sort(g);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]); // val, row, col
            for (int i=0; i<n; i++) {
                if (limits[i] <= 0) continue;
                pq.add(new int[]{grid[i][m-1], i, m-1});
            }

            long ans = 0;
            while (k>0) {
                int[] c = pq.poll();
                int val = c[0], row = c[1], col= c[2];
                ans+=val;
                int maxFromRow = limits[row];
                if (col-1>=0 && m-(col-1) <= maxFromRow) {
                    pq.add(new int[]{grid[row][col-1], row, col-1});
                }
                k--;
            }
            return ans;
        }
    }
}
