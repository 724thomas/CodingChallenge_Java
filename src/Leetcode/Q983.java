package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q983 {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            Set<Integer> setDays = new HashSet<>();
            for (int day : days) setDays.add(day);
            int[] dp = new int[366];

            for (int day=1; day<366; day++) {
                if (!setDays.contains(day)) {
                    dp[day] = dp[day-1];
                } else {
                    dp[day] = Math.min(
                            dp[Math.max(0, day-1)] + costs[0], Math.min(
                                    dp[Math.max(0, day-7)] + costs[1],
                                    dp[Math.max(0, day-30)] + costs[2]));
                }

            }
            return dp[365];
        }

        /*

         */
    }
}
