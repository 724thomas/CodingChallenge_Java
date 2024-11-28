# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :

class Solution {
    public int solution(int n) {
        for (int i=2; i<n; i++) {
            if (n%i == 1) return i;
        }
        return 0;
    }
}
'''



