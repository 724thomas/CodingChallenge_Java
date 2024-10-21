# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;
        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                toUpper=true;
                continue;
            }
            if (toUpper) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            toUpper = !toUpper;
        }
        return sb.toString();
    }
}

'''


def solution(s):
    ans = ''
    to_upper = True
    for c in s:
        if c == ' ':
            ans+=c
            to_upper=True
        else:
            ans = ans + c.upper() if to_upper else ans + c.lower()
            to_upper = not to_upper
    return ans