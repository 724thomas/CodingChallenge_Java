package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q46_2 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> candid = new ArrayList<>();
        int n;
        int[] nums;
        public List<List<Integer>> permute(int[] nums) {
            n = nums.length;
            this.nums = nums;

            backtrack();
            return ans;
        }

        public void backtrack() {
            if (candid.size() == n) {
                ans.add(List.copyOf(candid));
                return;
            }

            for (int num : nums) {
                if (visited.contains(num)) continue;
                visited.add(num);
                candid.add(num);

                backtrack();

                candid.remove(candid.size()-1);
                visited.remove(num);
            }
        }
    }
}
