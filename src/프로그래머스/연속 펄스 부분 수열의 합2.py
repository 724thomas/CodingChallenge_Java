# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long pos = 0, neg = 0, ans = 0;
        int mul = 1;
        for (int seq : sequence){
            pos = Math.max(pos + seq * mul, seq * mul);
            neg = Math.max(neg + seq * -mul, seq * -mul);
            ans = Math.max(ans, Math.max(pos, neg));
            mul *= -1;
        }
        return ans;
    }
}

'''

def solution(n, left, right):
    return [max( (i//n)+1, (i%n)+1) for i in range(left, right+1)]
