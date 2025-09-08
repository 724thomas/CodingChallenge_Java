package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2364 {
    class Solution {

        public long countBadPairs(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> counter = new HashMap<>();
            for (int i=0; i<n; i++) {
                counter.put(nums[i] - i, counter.getOrDefault(nums[i]-i, 0)+1);
            }

            long total = (long) n * (n - 1) / 2;
            for (int val : counter.values()) total -= (long) val * (val - 1) / 2;
            return total;
        }
    }
}
