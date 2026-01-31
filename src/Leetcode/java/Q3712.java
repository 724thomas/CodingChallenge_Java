package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3712 {
    class Solution {
        public int sumDivisibleByK(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();

            for (int num : nums) {
                counter.put(num, counter.getOrDefault(num, 0) + 1);
            }

            int ans = 0;
            for (var entry : counter.entrySet()) {
                int num = entry.getKey(), freq = entry.getValue();
                if (freq % k == 0) {
                    ans += num * freq;
                }
            }

            return ans;
        }
    }
}
