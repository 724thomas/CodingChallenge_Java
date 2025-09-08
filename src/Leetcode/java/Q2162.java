package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2162 {
    class Solution {
        int startAt, moveCost, pushCost, targetSeconds;
        int ans = Integer.MAX_VALUE;
        public int getSeconds(String time) {
            while (time.length() < 4) time = "0"+time;
            int seconds = 0;
            seconds += Integer.parseInt(time.substring(0, 2)) * 60;
            seconds += Integer.parseInt(time.substring(2));
            return seconds;
        }

        public void backtrack(int curr, String comb, int cost, int idx) {
            if (idx > 4) return;
            int seconds = getSeconds(comb);
            if (seconds == targetSeconds) {
                ans = Math.min(ans, cost);
                return;
            } else if (seconds > targetSeconds) return;

            for (int i=0; i<=9; i++) {
                backtrack(i, comb+String.valueOf(i),
                        i==curr? cost+pushCost : cost+moveCost + pushCost, idx+1);
            }
        }

        public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            this.moveCost = moveCost;
            this.pushCost = pushCost;
            this.targetSeconds = targetSeconds;

            backtrack(startAt, "", 0, 0);

            return ans;
        }
    }
}
