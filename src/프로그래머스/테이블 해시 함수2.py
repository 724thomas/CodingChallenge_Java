# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a,b) -> {
            if (a[col-1]==b[col-1]) return b[0]-a[0];
            return a[col-1]-b[col-1];
        });

        int ans = 0;
        for (int i=row_begin-1; i<=row_end-1; i++) {
            int total = 0;
            for (int j=0; j<data[i].length; j++) {
                total += data[i][j] % (i+1);
            }
            ans ^= total;
        }
        return ans;
    }
}
'''



