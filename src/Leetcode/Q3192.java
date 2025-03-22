package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3192 {
    class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length;
            int prev0 = (nums[n-1] == 0) ? 0 : 1;
            int prev1 = (nums[n-1] == 0) ? 1 : 0;
            int curr0 = prev0, curr1 = prev1;

            for (int i=n-2; i>-1; i--) {
                if (nums[i] == 0) {
                    curr0 = prev0;
                    curr1 = prev0+1;
                } else if (nums[i] == 1) {
                    curr0 = prev1+1;
                    curr1 = prev1;
                }
                prev0 = curr0;
                prev1 = curr1;
            }

            return curr1;

        }
    }
}
