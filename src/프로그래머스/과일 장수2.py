# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int n = score.length;
        int boxes = n / m;
        Arrays.sort(score);

        int ans = 0;
        for (int i=n-m; i>=n-(boxes*m); i-=m){
            ans += score[i] * m;
        }
        return ans;
    }
}'''
