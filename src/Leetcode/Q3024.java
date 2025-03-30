package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q3024 {
    class Solution {
        public String triangleType(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] + nums[1] <= nums[2]) return "none";
            Set<Integer> counter = new HashSet<>();
            for (int num : nums) counter.add(num);
            if (counter.size() == 1) return "equilateral";
            if (counter.size() == 2) return "isosceles";
            return "scalene";
        }
    }
}
