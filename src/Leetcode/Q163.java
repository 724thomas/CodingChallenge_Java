package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q163 {
    class Solution {
        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            List<List<Integer>> ans = new ArrayList<>();

            for (int num : nums) {
                if (lower < num) ans.add(Arrays.asList(lower, num-1));
                lower = num+1;
            }
            if (lower <= upper) ans.add(Arrays.asList(lower, upper));
            return ans;
        }
    }

}
