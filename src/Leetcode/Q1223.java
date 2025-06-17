package Leetcode;

/*
1. 아이디어 :
모든 주사위의 경우의 수를 구하는 dp[i][j]를 만듭니다.
여기에서 연속되는 숫자의 경우를 제외합니다.

rollMax[0]이 4라고 가정하면,
주사위를 4번 굴렸을때(i = 4),  1 1 1 1 일때 1가지 경우의 수가 존재하고,
주사위를 5번 굴렸을때(i = 5),  x 1 1 1 1 일떄는 dp[0][y] 에서 y가 2부터 6까지의 경우를 총합에서 제외. (dp[0][1]은 제외)
주사위를 6번 굴렸을때(i = 6),  x x 1 1 1 1 일떄는 dp[1][y] 에서 y가 2부터 6까지

결국 주사위를 굴릴때마다, 현재 j 눈금에 대해 계산을 하고 있을때, i - rollMax[j] - 1 번째 주사위를 굴렸을때의 경우의수를 제외.

2. 시간복잡도 :
O( n * 6 * 6 ) = O(n)

3. 자료구조/알고리즘 :
- / DP
 */

public class Q1223 {
    class Solution {
        public int dieSimulator(int n, int[] rollMax) {
            int MOD = 1_000_000_007;

            int[][] dp = new int[n+1][6];
            for (int i=0; i<6; i++) dp[0][i] = 1; // 1번 던졌을때 나올 수 있는 경우의 수

            for (int i=1; i<n; i++) { // i번 던졌을때
                for (int j=0; j<6; j++) { // j가 마지막 숫자
                    int total = 0;
                    for (int k = 0; k<6; k++) total = (total + dp[i-1][k]) % MOD;
                    dp[i][j] = total;

                /*
                최대 연속 [1,1,2,2,2,3]
                1. dp[i-1][1], dp[i][1]인 경우, dp[i-2][1], ...dp[i-2][6]까지의 합을 제외.
                                              i-2 = i - rollMax[j] - 1;
                */
                    if (i >= rollMax[j]) {
                        if (i == rollMax[j]) dp[i][j]--;
                        else {
                            for (int k = 0; k<6; k++) {
                                if (j != k) { // 같은 숫자일 경우, 길이가 더 길 수 있음.
                                    int dupIndex = i - rollMax[j] - 1;
                                    dp[i][j] = (dp[i][j] - dp[dupIndex][k] + MOD) % MOD;
                                }
                            }
                        }
                    }
                }
            }
            int ans = 0;
            for (int i=0; i<6; i++) ans = (ans + dp[n-1][i]) % MOD;
            return ans;
        }
    }
}
