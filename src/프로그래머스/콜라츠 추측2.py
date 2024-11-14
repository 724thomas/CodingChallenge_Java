# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public int solution(int num) {
        long n = num;
        for (int i = 0; i < 501; i++) {
            if (n == 1) return i;
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
        }
        return -1;
    }
}

'''

