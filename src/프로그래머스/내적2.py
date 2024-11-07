# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :


class Solution {
    public int solution(int[] a, int[] b) {
        int ans = 0;
        for (int i=0; i<a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }
}
'''

def solution(a, b):
    return sum([a[i] * b[i] for i in range(len(a))])
