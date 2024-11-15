# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        int idx = -1;
        for (int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx=i;
                break;
            }
        }
        return "김서방은 " + idx + "에 있다";
    }
}
'''



