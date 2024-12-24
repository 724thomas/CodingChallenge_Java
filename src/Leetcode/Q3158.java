package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3158 {
    class Solution {
        public int duplicateNumbersXOR(int[] nums) {
            int ans = 0;
            Set<Integer> visited = new HashSet<>();
            for (int num : nums) {
                if (visited.contains(num)) {
                    ans = ans ^ num;
                } else {
                    visited.add(num);
                }
            }
            return ans;
        }
    }
}
