package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q760 {
    class Solution {
        public int[] anagramMappings(int[] nums1, int[] nums2) {
            Map<Integer, Integer> idxs = new HashMap<>();
            for (int i=0; i<nums1.length; i++) idxs.put(nums2[i], i);

            int[] ans = new int[nums1.length];
            for (int i=0; i<nums1.length; i++) ans[i] = idxs.get(nums1[i]);
            return ans;
        }
    }
}
