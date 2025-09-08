package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q254 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> getFactors(int n) {
            backtrack(new ArrayList<>(), n, 2);
            return ans;
        }

        private void backtrack(List<Integer> curr, int idx, int start) {
            for (int i = start; i <= (int) Math.sqrt(idx); i++) {
                if (idx % i == 0) {
                    curr.add(i);
                    curr.add(idx / i);
                    ans.add(new ArrayList<>(curr));
                    curr.remove(curr.size() - 1);
                    backtrack(curr, idx / i, i);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
