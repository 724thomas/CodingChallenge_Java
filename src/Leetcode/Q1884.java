package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1884 {
    class Solution {
        public int twoEggDrop(int n) {
        /*
        1 - 100: 99
        2 - 99: 97
        3 - 97: 94
        4 - 94: 90
        5 - 90: 85
        6 - 85: 79
        7 - 79: 72
        8 - 72: 64
        9 - 64: 55
        10 - 55: 45
        11 - 45: 34
        12 - 34: 22
        13 - 22: 9
        */

            int count = 1;
            while (n > count) n -= count++;
            return count;

        }
    }
}
