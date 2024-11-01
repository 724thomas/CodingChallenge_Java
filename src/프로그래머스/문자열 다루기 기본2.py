# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :

class Solution {
    public boolean solution(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) return false;
        }
        return (s.length() == 4 || s.length() == 6);
    }
}

'''


def solution(s):
    if len(s) not in (4,6):
        return False
    try:
        int(s)
    except:
        return False
    return True