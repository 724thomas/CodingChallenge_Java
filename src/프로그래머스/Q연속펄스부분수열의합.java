package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[n+1][2];
        int mul = 1;
        long ans = 0;
        for (int i=0; i<n; i++) {
            int seq = sequence[i];
            dp[i+1][0] = Math.max(dp[i][0] + seq * mul, seq * mul);
            dp[i+1][1] = Math.max(dp[i][1] + seq * -mul, seq * -mul);
            ans = Math.max(ans, Math.max(dp[i+1][0], dp[i+1][1]));
            mul *= -1;
        }
        return ans;
    }
}
