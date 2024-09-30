# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution
{
    public int solution(int n, int a, int b) {
        int round = 1;
        while (true){
            round++;
            a = (a+1)/2;
            b = (b+1)/2;
            if (a==b){
                return round-1;
            }
        }
    }
}

'''


