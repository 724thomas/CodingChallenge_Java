# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++){
            for (int j=0; j<food[i]/2; j++){
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }
}

'''

def solution(food):
    ans = ""
    for i in range(1,len(food)):
        ans += str(i) * (food[i] //2)
    return ans + '0' + ans[::-1]