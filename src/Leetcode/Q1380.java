package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1380 {
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            Set<Integer> maximum = new HashSet<>();

            for (int row=0; row<matrix.length; row++) {
                int colMin = Integer.MAX_VALUE;
                for (int col = 0; col<matrix[0].length; col++) {
                    colMin = Math.min(colMin, matrix[row][col]);
                }
                maximum.add(colMin);
            }

            for (int col=0; col<matrix[0].length; col++) {
                int rowMax = 0;
                for (int row = 0; row<matrix.length; row++) {
                    rowMax = Math.max(rowMax, matrix[row][col]);
                }
                if (maximum.contains(rowMax)) ans.add(rowMax);
            }
            return ans;
        }
    }
}
