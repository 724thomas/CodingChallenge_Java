package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3502 {
    class Solution {
        public int[] minCosts(int[] cost) {
            for (int i=1; i<cost.length; i++) cost[i] = Math.min(cost[i-1], cost[i]);
            return cost;
        }
    }
}
