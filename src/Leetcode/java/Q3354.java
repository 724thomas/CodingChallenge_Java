package Leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class Q3354 {
    class Solution {
        public List<Integer> getInitialCurr (int[] nums) {
            List<Integer> currs = new ArrayList<>();
            for (int i = 0; i<nums.length; i++) if (nums[i] == 0) currs.add(i);
            return currs;
        }

        public int countValidSelections(int[] nums) {
            int N = nums.length, ans = 0;
            int[] ls = new int[N], rs = new int[N];

            for (int i=1; i<N; i++) {
                ls[i] = ls[i-1] + nums[i-1];
                rs[N-i-1] = rs[N-i] + nums[N-i];
            }

            for (int curr : getInitialCurr(nums)) {
                ans += Math.max(0, 2 - Math.abs(ls[curr] - rs[curr]));
            }
            return ans;
        }
    }
}
