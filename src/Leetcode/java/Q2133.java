package Leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class Q2133 {
    class Solution {
        public boolean checkValid(int[][] matrix) {
            int N = matrix.length;

            for (int row =0; row<N; row++) {
                Set<Integer> visited = new HashSet<>();
                for (int col=0; col<N; col++) {
                    int val = matrix[row][col];
                    if (val <= 0 || val > N || visited.contains(val)) return false;
                    visited.add(val);
                }
            }

            for (int col =0; col<N; col++) {
                Set<Integer> visited = new HashSet<>();
                for (int row=0; row<N; row++) {
                    int val = matrix[row][col];
                    if (val <= 0 || val > N || visited.contains(val)) return false;
                    visited.add(val);
                }
            }

            return true;
        }
    }
}
