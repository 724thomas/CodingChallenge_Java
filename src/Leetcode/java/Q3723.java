package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3723 {
    class Solution {
        public String maxSumOfSquares(int num, int sum) {
            if (sum > 9 * num) return ""; // 불가능

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < num; i++) {
                int digit = Math.min(9, sum);
                sb.append(digit);
                sum -= digit;
            }

            return sb.toString();
        }
    }

}
