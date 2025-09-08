package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3360 {
    class Solution {
        public boolean canAliceWin(int n) {
            int curr = 10;
            boolean aliceWin = false;
            while (n>=curr) {
                n -= curr;
                curr--;
                aliceWin = !aliceWin;
            }
            return aliceWin;

        }
    }
}
