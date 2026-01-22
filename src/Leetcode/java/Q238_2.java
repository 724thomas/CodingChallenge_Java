package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q238_2 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            long total = 1;
            int zeros = 0;
            for (int num : nums) {
                if (num == 0) {
                    zeros++;
                    continue;
                }
                total *= num;
            }


            for (int i=0; i<nums.length; i++) {
                if (zeros >= 2) {
                    nums[i] = 0;
                } else if (zeros == 1 && nums[i] != 0) {
                    nums[i] = 0;
                } else if (nums[i] == 0) {
                    nums[i] = (int)total;
                } else {
                    nums[i] = (int)(total/nums[i]);
                }
            }
            return nums;
        }
    }
}
