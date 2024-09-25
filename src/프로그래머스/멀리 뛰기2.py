'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public long solution(int n) {
        if (n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<n; i++) {
            dp[i] = (dp[i-2]+dp[i-1]) % 1234567;
        }
        return dp[n-1];
    }
}



'''


