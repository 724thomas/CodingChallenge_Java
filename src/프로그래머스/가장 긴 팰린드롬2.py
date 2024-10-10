# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution{
    int[][] dp;
    public int solution(String s){
        int n = s.length();
        if (n == 0) return 0;
        int ans = 1;
        dp = new int[n][n];
        for (int i=0; i<n; i++) dp[i][i] = 1;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                ans = 2;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int left=0; left<=n-length; left++) {
                int right = left + length-1;
                if (s.charAt(left) == s.charAt(right) && dp[left+1][right-1] == 1) {
                    dp[left][right] = 1;
                    ans = length;
                }
            }
        }
        return ans;
    }
}

'''

def solution(s):
    answer = 0
    for i in range(len(s)):
        for j in range(len(s), i, -1):
            if s[i:j] == s[i:j][::-1]:
                if answer < len(s[i:j]):
                    answer = len(s[i:j])
    return answer

def solution2(s):
    n = len(s)
    if n == 0: return 0
    ans = 1
    dp = [[False] * n for _ in range(n)]
    for i in range(n):
        dp[i][i] = True
    for i in range(n-1):
        if s[i] == s[i+1]:
            dp[i][i+1] = True
            ans = 2

    for length in range(3, n+1):
        for left in range(n-length+1):
            right = left + length-1
            if s[left] == s[right] and dp[left+1][right-1]:
                dp[left][right]=True
                ans=length

    return ans