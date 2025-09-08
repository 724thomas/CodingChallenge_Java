package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2661 {
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int rows = mat.length, cols = mat[0].length;
            Map<Integer, int[]> cords = new HashMap<>();
            int[] vrows = new int[rows], vcols = new int[cols];

            for (int i=0; i<rows; i++) for (int j=0; j<cols; j++) {
                cords.put(mat[i][j], new int[]{i, j});
            }

            for (int i=0; i<arr.length; i++) {
                int[] cord = cords.get(arr[i]);
                vrows[cord[0]]++;
                vcols[cord[1]]++;
                if (vrows[cord[0]] == cols || vcols[cord[1]] == rows) return i;
            }

            return arr.length;
        }
    }
}
