package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q78_2 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums;
        int n;
        public void backtrack(List<Integer> curr, int idx) {
            if (idx >= n) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            backtrack(curr, idx+1);
            curr.add(nums[idx]);
            backtrack(curr, idx+1);
            curr.remove(curr.size()-1);
        }

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            n = nums.length;
            backtrack(new ArrayList<>(), 0);
            return ans;
        }
    }
}
