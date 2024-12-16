# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    public boolean getDistance(int x, int y, int d) {
        return Math.sqrt(x*x + y*y) <= d;
    }
    public long solution(int k, int d) {
        long ans = 0;
        long d2 = (long)d*d;

        for (int x = 0;  x<=d; x+=k) {
            long x2 = (long)x*x;
            ans += (long)Math.sqrt(d2 - x2)/k + 1;
        }
        return ans;
    }
}
'''



