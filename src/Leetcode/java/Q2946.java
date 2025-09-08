package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q2946 {
    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int n = mat.length, m = mat[0].length;
            List<Deque<Integer>> grid = new ArrayList<>();
            for (int i=0; i<n; i++) {
                Deque<Integer> row = new ArrayDeque<>();
                for (int j=0; j<m; j++) {
                    row.add(mat[i][j]);
                }
                grid.add(row);
            }
            for (int rep = 0; rep<k; rep++) {
                for (int i=0; i<n; i++) {
                    Deque<Integer> row = grid.get(i);
                    if (i%2 ==0) { //even
                        row.addLast(row.pollFirst());
                    } else { //odd
                        row.addFirst(row.pollLast());
                    }
                }
            }

            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (mat[i][j] != grid.get(i).pollFirst()) return false;
            }
            return true;
        }
    }
}
