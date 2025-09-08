package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q756 {
    class Solution {
        int n;
        char[][] pyramid;
        boolean ans = false;
        List<String> allowed;
        Map<String, List<Character>> blocks = new HashMap<>();

        public int[] getNextCord(int row, int col) {
            if (col == n - row-1) {
                return new int[]{row+1, 0};
            } else {
                return new int[]{row, col+1};
            }
        }

        public void backtrack(int row, int col) {
            if (ans) return;
            if (row == n) {
                ans = true;
                return;
            }


            String key = pyramid[row-1][col] + "" + pyramid[row-1][col+1];
            for (char candid : blocks.getOrDefault(key, new ArrayList<>())) {
                pyramid[row][col] = candid;

                int[] nextCord = getNextCord(row, col);
                backtrack(nextCord[0], nextCord[1]);
            }
        }

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            n = bottom.length();
            pyramid = new char[n][n];
            this.allowed = allowed;

            for (String block : allowed) {
                String key = block.substring(0,2);
                blocks.putIfAbsent(key, new ArrayList<>());
                blocks.get(key).add(block.charAt(2));
            }

            for (int i=0; i<n; i++) pyramid[0][i] = bottom.charAt(i);
            backtrack(1, 0);

            return ans;
        }
    }
}
