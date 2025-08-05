package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int total = 1;
            int zeroCount = 0;
            for (int num : nums) {
                if (num !=0) total *= num;
                if (num == 0) zeroCount++;
            }

            for (int i=0; i<nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = zeroCount>=2? 0:total;
                } else {
                    nums[i] = zeroCount>=1? 0: total/nums[i];
                }
            }
            return nums;
        }
    }
}
