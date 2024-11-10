package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    class Solution {
        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            List<List<Integer>> ans = new ArrayList<>();

            int prev = lower - 1;

            for (int i = 0; i <= nums.length; i++) {
                int curr = i < nums.length ? nums[i] : upper + 1;

                if (prev + 1 <= curr - 1) {
                    ans.add(List.of(prev + 1, curr - 1));
                }

                prev = curr;
            }

            return ans;
        }
    }

}

