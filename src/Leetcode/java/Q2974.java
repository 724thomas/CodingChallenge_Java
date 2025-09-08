package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q2974 {
    class Solution {
        public int[] numberGame(int[] nums) {
            int n= nums.length;
            int[] ans = new int[n];
            Arrays.sort(nums);
            int idx=0;

            for (int i=0; i<n; i+=2) {
                ans[idx++] = nums[i+1];
                ans[idx++] = nums[i];
            }
            return ans;
        }
    }
}
