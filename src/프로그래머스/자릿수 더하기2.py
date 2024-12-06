# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        for (Character c : String.valueOf(n).toCharArray()) {
            ans += Integer.parseInt(c+"");
        }
        return ans;
    }
}
'''



