package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            int total = n * (n+1) / 2;
            int sum = 0;

            int[] ans = new int[2];
            Set<Integer> dup = new HashSet<>();

            for (int num : nums) {
                sum+=num;
                if (dup.contains(num)) ans[0] = num;
                dup.add(num);
            }
            ans[1] = ans[0] + total - sum;


            return ans;
        }
    }
}
