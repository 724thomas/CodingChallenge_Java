# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int idx = 0, ans = 0;
        while (idx < routes.length) {
            ans++;
            int camera = routes[idx++][1];
            while (idx < routes.length && camera >= routes[idx][0]) {
                idx++;
            }
        }
        
        return ans;
    }
}'''
