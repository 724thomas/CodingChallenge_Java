# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    //마지막 타일이 가로일떄 (n-2) , 세로일때 (n-1)
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
'''


