package Leetcode;

/*
1. 아이디어 :
dp를 사용합니다. days가 10이하인걸 봐서 백트래킹이 가능할것 같지만, 실제로 계산해보면 300^10이 됩니다.
bottom-up 방식으로 접근합니다. 종료 조건은
- days가 0이고, idx가 n이면 더 이상 일을 할 수 없으므로 0을 반환합니다.
- days가 0인데, idx가 n이 아니면 일을 다 못했으므로 결과값을 사용하지 않도록 Integer.MAX_VALUE를 반환합니다.

idx부터 끝까지 순회를 하면서 dfs를 호출합니다. dp 캐시을 통해 중복 계산을 방지합니다.

2. 시간복잡도 :
O( n * d )

3. 자료구조/알고리즘 :
2차원 배열 / dp
 */

public class Q1335 {
    class Solution {
        int n;
        int ans = Integer.MAX_VALUE;
        int[] jobDifficulty;
        Integer[][] dp;

        public int dfs(int idx, int remainingDays) {
            if (remainingDays == 0 && idx == n) return 0;
            if (remainingDays == 0 || idx == n) return Integer.MAX_VALUE;
            if (dp[idx][remainingDays] != null) return dp[idx][remainingDays];

            int cmax = 0;
            int ans = Integer.MAX_VALUE;
            for (int i = idx; i<n; i++) {
                cmax = Math.max(cmax, jobDifficulty[i]);
                int next = dfs(i+1, remainingDays-1);
                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, cmax + next);
                }
            }

            dp[idx][remainingDays] = ans;
            return ans;
        }

        public int minDifficulty(int[] jobDifficulty, int d) {
            n = jobDifficulty.length;
            if (n<d) return -1;
            this.jobDifficulty = jobDifficulty;
            dp = new Integer[n][d+1];
            return dfs(0, d);
        }
    }
}
