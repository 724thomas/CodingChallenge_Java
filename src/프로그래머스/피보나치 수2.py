# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<n+1; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}'''

