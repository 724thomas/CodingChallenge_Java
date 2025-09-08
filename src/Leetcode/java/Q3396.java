package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3396 {
    class Solution {
        public int minimumOperations(int[] nums) {
            int removeIdx = 0, checkIdx = nums.length-1;
            int ans = 0;
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) counter.put(num, counter.getOrDefault(num, 0)+1);

            while (removeIdx < checkIdx) {
                int check = nums[checkIdx];
                while (counter.get(check) > 1) {
                    for (int i = 0; i<3; i++) {
                        if (removeIdx == nums.length) continue;
                        int remove = nums[removeIdx++];
                        counter.put(remove, counter.getOrDefault(remove, 0)-1);
                    }
                    ans++;
                }
                checkIdx--;
            }
            return ans;
        }
    }
}
