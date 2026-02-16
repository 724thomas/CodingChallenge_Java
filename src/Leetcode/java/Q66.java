package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            boolean add = true;
            for (int i=n-1; i>=0; i--) {
                if (add) digits[i]++;
                add = false;

                if (digits[i] == 10) {
                    digits[i] = 0;
                    add=true;
                }
            }

            if (add) {
                int[] temp = new int[digits.length+1];
                temp[0] = 1;
                for (int i=1; i<digits.length; i++) {
                    temp[i] = digits[i-1];
                }
                digits = temp;
            }

            return digits;
        }
    }
}
