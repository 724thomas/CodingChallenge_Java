package Leetcode;

/*
1. 아이디어 :
dp 문제.
int[][] dp = new int[n][2]; i번째까지 왔을때 짝수, 홀수 갯수
dp[i][0] = 짝수 갯수, dp[i][1] = 홀수 갯수

현재 값이 짝수이면:
    짝수 갯수 = 이전 짝수 갯수 + 1
    홀수 갯수 = 이전 홀수 갯수
현재 값이 홀수이면:
    짝수 갯수 = 이전 홀수 갯수
    홀수 갯수 = 이전 짝수 갯수 + 1



2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / DP
 */

public class Q1524 {
    class Solution {
        public int numOfSubarrays(int[] arr) {
            int MOD = 1_000_000_007;
            int n = arr.length;

            int prevEven = arr[0] % 2 == 0? 1: 0;
            int prevOdd = arr[0] % 2 == 0? 0: 1;
            int ans = prevOdd;

            for (int i=1; i<n; i++) {
                int currEven, currOdd;

                if (arr[i] % 2 == 0) {
                    currEven = (prevEven+1) % MOD;
                    currOdd = (prevOdd) % MOD;
                } else {
                    currEven = (prevOdd) % MOD;
                    currOdd = (prevEven+1) % MOD;
                }

                ans = (ans + currOdd) % MOD;
                prevEven = currEven;
                prevOdd = currOdd;
            }
            return ans;
        }
    }
}
