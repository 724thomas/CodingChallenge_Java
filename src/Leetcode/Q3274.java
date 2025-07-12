package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3274 {
    class Solution {
        public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
            int c1 = coordinate1.charAt(0)-'a' + coordinate1.charAt(1)-'1';
            int c2 = coordinate2.charAt(0)-'a' + coordinate2.charAt(1)-'1';
            return c1 % 2 == c2 % 2;
        }
    }
}
