package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1272 {
    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int[] interval : intervals) {
                // covers
                if (toBeRemoved[0] <= interval[0] && interval[1] <= toBeRemoved[1]) continue;
                    //left or right
                else if (interval[1] <= toBeRemoved[0] || toBeRemoved[1] <= interval[0]) ans.add(Arrays.asList(interval[0], interval[1]));
                    //includes
                else if (interval[0] < toBeRemoved[0] && toBeRemoved[1] < interval[1]) {
                    ans.add(Arrays.asList(interval[0], toBeRemoved[0]));
                    ans.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }

                else if (interval[0] < toBeRemoved[0]) ans.add(Arrays.asList(interval[0], toBeRemoved[0]));
                else if (toBeRemoved[1] < interval[1]) ans.add(Arrays.asList(toBeRemoved[1], interval[1]));
            }
            return ans;
        }
    }
}
