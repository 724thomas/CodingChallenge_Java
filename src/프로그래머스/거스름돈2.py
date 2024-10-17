# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int coin:money) {
            for (int i=coin; i<n+1; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % MOD;
            }
        }
        return dp[n];
    }
}

'''

def solution(n, money):
    MOD = 1000000007;
    dp = [0 for _ in range(n+1)]
    dp[0] = 1
    for coin in money:
        for i in range(coin, n+1):
            dp[i] = (dp[i] + dp[i-coin]) % MOD
    return dp[n]