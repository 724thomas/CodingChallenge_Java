# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> candid = new HashSet<>();
        for (var phone:phone_book) candid.add(phone);
        for (int i=0; i<phone_book.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<phone_book[i].length()-1; j++) {
                sb.append(phone_book[i].charAt(j));
                if (candid.contains(sb.toString())){
                    return false;
                }
            }
        }
        return true;
    }
}

'''

def solution(phone_book):
    phone_book = set(phone_book)
    for pn in phone_book:
        temp = ""
        for i in range(len(pn)-1):
            temp+=pn[i]
            if temp in phone_book:
                return False
    return True
