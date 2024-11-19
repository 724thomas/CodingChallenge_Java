# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public boolean solution(int x) {
        int posTotal = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            posTotal += Integer.parseInt(c+"");
        }
        return x%posTotal == 0;
    }
}
'''



