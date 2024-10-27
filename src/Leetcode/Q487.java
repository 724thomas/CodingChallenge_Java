package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q487 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            Map<Integer, Integer> counter = new HashMap<>();
            counter.put(0,0);
            counter.put(1,0);
            int ans = 0;
            int left = 0;

            for (int right =0; right<nums.length; right++){
                counter.put(nums[right], counter.get(nums[right])+1);
                while (counter.get(0) == 2) counter.put(nums[left], counter.get(nums[left++])-1);
                ans = Math.max(ans, right-left+1);
            }
            return ans;
        }
    }
}
