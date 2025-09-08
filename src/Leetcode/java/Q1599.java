package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1599 {
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int waiting = 0, profit = 0;
            int maxProfit = 0, ans = -1;
            int customersIdx = 0, round = 0;

            while (waiting > 0 || customersIdx < customers.length) {
                round++;

                if (customersIdx < customers.length) {
                    waiting += customers[customersIdx++];
                }

                int board = Math.min(4, waiting);
                waiting -= board;

                profit += board * boardingCost - runningCost;

                if (profit > maxProfit) {
                    maxProfit = profit;
                    ans = round;
                }
                System.out.println(profit);
            }

            return ans;
        }
    }

}
