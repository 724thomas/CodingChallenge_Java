# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append((char) ((c - 'a' + n) % 26 + 'a'));
            } else if (Character.isUpperCase(c)) {
                sb.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

'''


