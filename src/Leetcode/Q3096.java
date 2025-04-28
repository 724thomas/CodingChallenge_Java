package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3096 {
    class Solution {
        public int minimumLevels(int[] possible) {
            int n = possible.length;
            int bob = 0;
            for (int num : possible) {
                bob += num==1? 1 : -1;
            }

            int alice = 0;
            for (int i=0; i<n-1; i++) {
                if (possible[i] == 1) {
                    alice++;
                    bob--;
                } else {
                    alice--;
                    bob++;
                }

                if (alice > bob) return i+1;
            }

            return -1;
        }
    }
}
