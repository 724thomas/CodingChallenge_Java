package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int[] candidates;
        int target;
        int n;

        public void backtrack(List<Integer> curr, int total, int idx) {
            if (total == target) {
                ans.add(new ArrayList<>(curr));
                return;
            }
            if (total > target) return;

            for (int i = idx; i < n; i++) {
                if (i > idx && candidates[i] == candidates[i - 1]) continue;

                curr.add(candidates[i]);
                backtrack(curr, total + candidates[i], i + 1);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            this.target = target;
            this.n = candidates.length;
            backtrack(new ArrayList<>(), 0, 0);
            return ans;
        }
    }

}
