package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2917 {
    class Solution {
        public int findKOr(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                for (int bit = 0; bit < 32; bit++) {
                    if (((num >> bit) & 1) == 1) {
                        counter.put(bit, counter.getOrDefault(bit, 0) + 1);
                    }
                }
            }

            int result = 0;
            for (int bit = 0; bit < 32; bit++) {
                if (counter.getOrDefault(bit, 0) >= k) {
                    result |= (1 << bit);
                }
            }

            return result;
        }
    }

}
