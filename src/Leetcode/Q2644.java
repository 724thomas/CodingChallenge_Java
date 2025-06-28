package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2644 {
    class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int ans = Integer.MAX_VALUE, cmax = 0;
            for (int div : divisors) {
                int count = 0;
                for (int num : nums) {
                    if (num % div == 0) count++;
                }
                if (cmax < count) {
                    ans = div;
                    cmax = count;
                } else if (cmax == count && div < ans) {
                    ans = div;
                }
            }
            return ans;
        }
    }
}
