package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2980 {
    class Solution {
        public boolean hasTrailingZeros(int[] nums) {
            int counter = 0;
            for (int num : nums) {
                String bin = Integer.toBinaryString(num);
                if (bin.charAt(bin.length()-1) == '0' && ++counter == 2) return true;
            }
            return false;
        }
    }
}
