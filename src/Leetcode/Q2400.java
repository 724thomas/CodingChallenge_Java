package Leetcode;

/*
1. 아이디어 :
2차원 배열 int[3001][k+1]을 만듭니다.
최소 값은 -1000, 최대값은 2000 이므로, 오프셋 1000인 3001길이 배열을 만듭니다.
dp를 활용해서, 0번째에 startPos점수가 나올 수 있는 경우의 수 1로 초기화합니다.
순회를 하면서 i번째 num의 경우의수 갯수는 i+1번째 num-1과 num+1의 경우의 수에 더해줍니다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
2차원 배열 / dp
 */

public class Q2400 {
    class Solution {
        public int numberOfWays(int startPos, int endPos, int k) {
            int MOD = 1_000_000_007;
            int offset = 1000;
            int[][] dp = new int[3001][k+1];
            dp[startPos+offset][0] = 1;

            for (int i=0; i<k; i++) {
                for (int j=0; j<3001; j++) {
                    int count = dp[j][i];
                    if (count == 0) continue;
                    dp[j+1][i+1] = (dp[j+1][i+1]+ count) % MOD;
                    dp[j-1][i+1] = (dp[j-1][i+1]+ count) % MOD;
                }
            }


            return dp[endPos+offset][k];
        }
    }
}
