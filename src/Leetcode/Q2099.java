package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2099 {
    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int[] ans = new int[k];
            int idx = 0;
            int[] nums2 = nums.clone();
            Arrays.sort(nums);

            Map<Integer, Integer> counter = new HashMap<>();
            for (int i=nums.length-k; i<nums.length; i++) {
                int num = nums[i];
                counter.put(num, counter.getOrDefault(num, 0)+1);
            }

            for (int num : nums2) {
                if (counter.getOrDefault(num, 0) > 0) {
                    counter.put(num, counter.getOrDefault(num,0)-1);
                    ans[idx++] = num;
                }
            }
            return ans;
        }
    }
}
