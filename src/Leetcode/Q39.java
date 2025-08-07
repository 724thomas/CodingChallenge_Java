package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int[] candidates;
        int target;
        int n;
        public void backtrack(List<Integer> curr, int total, int idx) {
            if (total >= target) {
                if (total == target) {
                    ans.add(new ArrayList<>(curr));
                }
                return;
            }

            for (int i=idx; i<n; i++) {
                curr.add(candidates[i]);
                backtrack(curr, total + candidates[i], i);
                curr.remove(curr.size()-1);
            }

        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates=candidates;
            this.target=target;
            n = candidates.length;
            backtrack(new ArrayList<>(), 0, 0);
            return ans;
        }
    }
}
