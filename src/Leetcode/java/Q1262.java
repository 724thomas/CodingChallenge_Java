package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q1262 {
    class Solution {
        Set<Integer> candids = new HashSet<>();
        public int maxSumDivThree(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][3]; // i번째 숫자까지 나머지 j 몫인 경우
            dp[0][nums[0]%3] = nums[0];

            for (int i=1; i<n; i++) {
                int num = nums[i];
                for (int j=0; j<3; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    int total = num + dp[i-1][j];
                    dp[i][total%3] = Math.max(dp[i][total%3], total);
                }
            }

            return dp[n-1][0];
        }
    }
}
