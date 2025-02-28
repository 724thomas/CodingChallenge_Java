package Leetcode;

/*
1. 아이디어 :
3차원 배열 int[n+1][3][2001]을 만듭니다.
n은 s의 길이, 3은 경우의 수(F,W,E), 2001은 -1000~1000까지의 점수입니다.
초기에 F,W,E에 대해 점수를 dp[0][1,2,3][-1, 0, -1]에 1가지씩 넣습니다.
1부터 순회를 하면서 그직전의 값들을 통해 다음 값을 계산하여 더합니다.

2. 시간복잡도 :
O( n * n*2 * 3 * 3)

3. 자료구조/알고리즘 :
3차원 배열 / dp
 */

public class Q3320 {
    class Solution {
        int MOD = 1_000_000_007;

        public int getScore(int alice, int bob) {
            int[][] scoreTable = {
                    {0, 1, -1},
                    {-1, 0, 1},
                    {1, -1, 0}
            };
            return scoreTable[alice][bob];
        }

        public String serialize(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'F') {
                    sb.append('0');
                } else if (c == 'W') {
                    sb.append('1');
                } else if (c == 'E') {
                    sb.append('2');
                }
            }
            return sb.toString();
        }

        public int countWinningSequences(String s) {
            s = serialize(s);
            int n = s.length();
            int[][][] dp = new int[n + 1][3][2001];
            int offset = 1000;

            int firstAlice = Integer.parseInt(s.charAt(0)+"");
            for (int bob = 0; bob < 3; bob++) {
                int diff = getScore(firstAlice, bob);
                dp[1][bob][diff + offset] = (dp[1][bob][diff + offset] + 1) % MOD;
            }

            for (int i = 1; i < n; i++) {
                int alice = Integer.parseInt(s.charAt(i)+"");
                for (int bobPrev = 0; bobPrev < 3; bobPrev++) {
                    for (int score = 0; score <= 2000; score++) {
                        int count = dp[i][bobPrev][score];
                        if (count == 0) continue;

                        for (int bobCur = 0; bobCur < 3; bobCur++) {
                            if (bobCur == bobPrev) continue;

                            int newScore = score+ getScore(alice, bobCur);
                            dp[i + 1][bobCur][newScore] = (dp[i + 1][bobCur][newScore] + count) % MOD;
                        }
                    }
                }
            }

            int ans = 0;
            for (int bob = 0; bob < 3; bob++) {
                for (int score = offset + 1; score <= 2000; score++) {
                    ans = (ans + dp[n][bob][score]) % MOD;
                }
            }

            return ans;
        }
    }

}
