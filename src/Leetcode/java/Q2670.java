package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2670 {
    class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
            for (int num:nums) {
                right.put(num, right.getOrDefault(num, 0)+1);
            }

            int[] ans = new int[n];
            for (int i=0; i<n; i++) {
                int num = nums[i];
                left.put(num, left.getOrDefault(num, 0)+1);
                right.put(num, right.get(num)-1);
                if (right.get(num)==0) right.remove(num);
                ans[i] = left.size() - right.size();
            }

            return ans;
        }
    }
}
