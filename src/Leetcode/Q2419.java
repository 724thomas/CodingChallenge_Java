package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2419 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int cmax = 0;
            int count = 0;
            int ans = 0;
            for (int num : nums) {
                if (num > cmax) {
                    cmax = num;
                    count = 1;
                    ans = 1;
                } else if (num == cmax) {
                    count++;
                } else if (num < cmax) {
                    count = 0;
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
}
