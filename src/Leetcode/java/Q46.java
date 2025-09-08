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

public class Q46 {
    class Solution {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n;
        int[] nums;
        public void dfs(List<Integer> curr) {
            if (curr.size() == n) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int i=0; i<n; i++) {
                if (visited.contains(i)) continue;
                visited.add(i);
                curr.add(nums[i]);
                dfs(curr);
                curr.remove(curr.size()-1);
                visited.remove(i);
            }
        }
        public List<List<Integer>> permute(int[] nums) {
            n = nums.length;
            this.nums=nums;
            dfs(new ArrayList<>());

            return ans;
        }
    }
}
