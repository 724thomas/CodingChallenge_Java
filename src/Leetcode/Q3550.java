package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3550 {
    class Solution {
        public int sumOfDigits(int num) {
            int total = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                total += Integer.parseInt(c+"");
            }
            return total;
        }
        public int smallestIndex(int[] nums) {
            for (int i=0; i<nums.length; i++) {
                if (i == sumOfDigits(nums[i])) return i;
            }
            return -1;
        }
    }
}
