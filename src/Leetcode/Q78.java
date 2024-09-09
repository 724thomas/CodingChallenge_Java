package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.*;
public class Q78 {
    static void dfs(int[] nums, ArrayList<Integer> curr, int idx, Set<List<Integer>> set, int length) {
        set.add(new ArrayList<>(curr));
        if (idx == length) {
            return;
        }

        for (int i = idx; i < length; i++) {
            curr.add(nums[i]);
            dfs(nums, curr, i + 1, set, length);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();
        dfs(nums, curr, 0, set, nums.length);

        return new ArrayList<>(set); // Set을 List로 변환하여 반환
    }
}
