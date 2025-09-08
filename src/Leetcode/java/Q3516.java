package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3516 {
    class Solution {
        public int findClosest(int x, int y, int z) {
            int disA = Math.abs(z-x), disB = Math.abs(z-y);
            return (disA == disB )? 0 : (disA < disB) ? 1: 2;
        }
    }
}
