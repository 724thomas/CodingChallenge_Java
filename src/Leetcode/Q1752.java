package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1752 {
    class Solution {
        public boolean check(int[] nums) {
            int check = 0;
            int length = nums.length;
            for (int i=0; i<length; i++) {
                if (nums[i] > nums[(i + 1) % length])
                    check += 1;
            }
            return check <= 1;
        }
    }
}
