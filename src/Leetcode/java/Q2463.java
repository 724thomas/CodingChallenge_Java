package Leetcode.java;

/*
1. 아이디어 :
dp문제.
로봇, 공장을 정렬한 후, 공장들을 펼칩니다.
dp[i][j] = i번째 로봇이 j번째 공장으로 갔을때의 최소값.

dfs를 사용.
종료조건:
- 로봇을 모두 순회했으면 0을 리턴
- 공장을 모두 순회했으면 Long.MAX_VALUE를 리턴 (로봇이 남았음)

현재 로봇을 j번째 공장으로 보내고, 다음 로봇을 j+1번째 공장으로 보내는 경우와
현재 로봇을 j+1번째 공장으로 보내는 경우를 비교
- 이때 가능한 경우인지 확인
- j+2번째 공장으로 보내는 경우는, helper를 호출함으로 내부적으로 처리됨.

2. 시간복잡도 :
O( n * m ) m = 공장이 수용할 수 있는 로봇의 수.

3. 자료구조/알고리즘 :
dp / dfs
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2463 {
    class Solution {
        Long[][] dp;
        List<Integer> robot;
        int[][] factory;
        int[] totalFactory;
        int n;
        int m=0;

        /*
            공장, .. 공장 < 로봇 <= 공장일때,
            로봇이 항상 가장 왼쪽 공장으로 가면 무조건 가능.
            가장 왼쪽 공장으로 가는게 이득이면, 무조건 왼쪽 공장으로 간다.
            그 다음 공장으로 가게되면, 불가능한 경우가 생길 수도 있음.

            로봇 <= 공장 일때,
            로봇은 항상 오른쪽 공장으로 가면 됨.

            가장 왼쪽 공장을 채우는 방법은 항상 가능.

            */
        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            Collections.sort(robot);
            Arrays.sort(factory, (a, b)->a[0]-b[0]);
            this.robot = robot;
            this.factory = factory;
            n = robot.size();


            for (int[] f : factory) m += f[1];
            totalFactory = new int[m];
            int idx = 0;
            for (int[] f : factory) for (int i=0; i<f[1]; i++) {
                totalFactory[idx++] = f[0];
            }
            System.out.println(Arrays.toString(totalFactory));
            if (m<n) return -1;

            dp = new Long[n][m];
            //i번째 로봇이 j번째 공장으로 갔을때의 최소값
            //j번째 공장에 갔으면, 그 다음은 j+1번쨰 공장부터 avail까지.
            return helper(0, 0);
        }

        public long helper(int i, int j) {
            if (i == n) return 0;
            if (j == m) return Long.MAX_VALUE; // robots left
            if (dp[i][j] != null) return dp[i][j];

            dp[i][j] = helper(i, j+1); // 현재 로봇을 j+1 공장으로

            long next = helper(i+1, j+1); // 현재 로봇을 j 공장으로 가고, 다음 로봇을 j+1 공장으로
            if (next != Long.MAX_VALUE) {
                long a = Math.abs(robot.get(i) - totalFactory[j]) + next;
                dp[i][j] = Math.min(dp[i][j], a);
            }
            return dp[i][j];

        }
    }
}
