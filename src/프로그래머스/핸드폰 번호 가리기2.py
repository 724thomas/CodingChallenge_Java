# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(1)
3. 자료구조 :


class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<phone_number.length()-4; i++) sb.append("*");
        sb.append(phone_number.substring(phone_number.length()-4, phone_number.length()));
        return sb.toString();
    }
}
'''

def solution(phone_number):
    return "*" * (len(phone_number)-4) + phone_number[len(phone_number)-4:]
