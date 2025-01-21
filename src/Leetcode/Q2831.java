package Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2831 {
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            int cmax = 0;
            int left = 0;

            for (int right = 0; right < nums.size(); right++) {
                int rightNum = nums.get(right);
                counter.put(rightNum, counter.getOrDefault(rightNum, 0)+1);
                cmax = Math.max(cmax, counter.get(rightNum));

                while ((right - left + 1) - cmax > k) {
                    int leftNum = nums.get(left);
                    counter.put(leftNum, counter.get(leftNum)-1);
                    left++;
                }
            }
            return cmax;
        }
    }
}
