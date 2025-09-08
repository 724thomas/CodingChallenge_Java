package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q1824 {
    class Solution {

        public int minSideJumps(int[] obstacles) {
            int n = obstacles.length;
            int[][] dp = new int[n][3]; //i번쨰 포인트, j번째 레인에 도착했을떄의 최소 점프

            for (int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0] = new int[]{1,0,1};

            for (int point = 1; point < n; point++) {
                // 직진
                for (int lane = 0; lane < 3; lane++) {
                    if (obstacles[point] -1 == lane) continue;
                    dp[point][lane] = dp[point-1][lane];
                }

                // 사이드 점프
                for (int lane = 0; lane < 3; lane++) {
                    if (obstacles[point]-1 == lane) continue;
                    for (int prev_lane = 0; prev_lane < 3; prev_lane++) {
                        if (prev_lane==lane || obstacles[point]-1 == prev_lane) continue;
                        if (dp[point][prev_lane] != Integer.MAX_VALUE) {
                            dp[point][lane] = Math.min(dp[point][lane], dp[point][prev_lane] + 1);
                        }
                    }
                }
            }

            return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        }
    }
}
