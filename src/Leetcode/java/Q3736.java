package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3736 {
    class Solution {
        public int minMoves(int[] nums) {
            int maxVal = 0;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }

            int ans = 0;
            for (int num : nums) {
                ans += maxVal - num;
            }
            return ans;
        }
    }
}
