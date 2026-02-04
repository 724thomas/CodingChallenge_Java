package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q53 {
    class Solution {
        public int getMaximumConsecutive(int[] coins) {
            Arrays.sort(coins);

            long reach = 0;
            for (int coin : coins) {
                if (coin > reach + 1) {
                    break;
                }
                reach += coin;
            }

            return (int)(reach+1);
        }
    }
}
