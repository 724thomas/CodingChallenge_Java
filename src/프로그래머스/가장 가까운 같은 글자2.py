# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        int[] ans = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            Character curr = s.charAt(i);
            ans[i] = lastIdx.containsKey(curr)? i- lastIdx.get(curr) : -1;
            lastIdx.put(curr, i);
        }
        return ans;
    }
}

'''


def solution(s):
    ans = []
    index={}
    for i, c in enumerate(s):
        if c not in index:
            ans.append(-1)
            index[c]=i
        elif c in index:
            ans.append(i-index[c])
            index[c]=i
    return ans