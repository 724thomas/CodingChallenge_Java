package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q3745 {
    class Solution {
        public int maximizeExpressionOfThree(int[] nums) {
            int[] candid = new int[3];
            Arrays.fill(candid, Integer.MIN_VALUE);
            candid[2] = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num >= candid[0]) {
                    candid[1] = candid[0];
                    candid[0] = num;
                } else if (num >= candid[1]) {
                    candid[1] = num;
                }
                candid[2] = Math.min(candid[2], num);
            }
            return candid[0] + candid[1] - candid[2];
        }
    }
}
