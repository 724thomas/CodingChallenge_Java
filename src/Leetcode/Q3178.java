package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3178 {
    class Solution {
        public int numberOfChild(int n, int k) {
            int child = 0;
            int dir = -1;

            for (int i=0; i<=k-1; i++) {
                if (child == 0 || child == n-1) dir *=-1;
                child+=dir;
            }

            return child;
        }
    }
}
