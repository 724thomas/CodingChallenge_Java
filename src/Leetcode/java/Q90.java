package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q90 {
    class Solution {
        Set<List<Integer>> temp = new HashSet<>();
        int[] nums;
        int n;

        public void backtrack(List<Integer> curr, int idx) {
            if (idx >=n) {
                List<Integer> candid = new ArrayList<>(curr);
                Collections.sort(candid);
                temp.add(candid);
                return;
            }

            backtrack(curr, idx+1);
            curr.add(nums[idx]);
            backtrack(curr, idx+1);
            curr.remove(curr.size()-1);
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            this.nums = nums;
            n = nums.length;
            Arrays.sort(nums);
            backtrack(new ArrayList<>(), 0);
            List<List<Integer>> ans = new ArrayList<>();
            for (List<Integer> candid : temp) ans.add(candid);
            return ans;
        }
    }
}
