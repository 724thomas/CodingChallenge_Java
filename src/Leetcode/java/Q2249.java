package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2249 {
    class Solution {
        public int countLatticePoints(int[][] circles) {
            int count = 0;
            for (int i=0; i<=200; i++) {
                for (int j=0; j<=200; j++) {
                    for (int[] circle : circles) {
                        int x=circle[0]-i;
                        int y=circle[1]-j;
                        int r=circle[2];
                        if( (x*x) + (y*y) <= (r*r) ) {
                            count++;
                            break;
                        }
                    }
                }
            }
            return count;
        }
    }
}
