package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int ans = nums[0];
            int cmin = nums[0];
            int cmax = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];

                if (num < 0) {
                    int tmp = cmax;
                    cmax = cmin;
                    cmin = tmp;
                }

                cmax = Math.max(num, cmax * num);
                cmin = Math.min(num, cmin * num);

                ans = Math.max(ans, cmax);
            }

            return ans;
        }
    }

}
