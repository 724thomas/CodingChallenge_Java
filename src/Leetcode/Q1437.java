package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1437 {
    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            int gap = k;
            for (int num : nums) {
                if (num == 1) {
                    if (gap<k) return false;
                    gap = 0;
                } else {
                    gap++;
                }
            }
            return true;
        }
    }
}
