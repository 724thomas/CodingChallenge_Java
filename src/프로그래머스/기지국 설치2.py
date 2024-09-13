# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int range = w * 2 + 1;
        int ans = 0, count = 0;
        int curr = 1;

        for (int station : stations) {
            int left = station - w;
            if (curr < left) {
                count = left - curr;
                ans += count % range == 0 ? count/range : count/range+1;
            }
            curr = station + w + 1;
        }

        if (curr <= n) {
            count = n - curr + 1;
            ans += count % range == 0 ? count/range : count/range+1;
        }

        return ans;
    }
}'''
