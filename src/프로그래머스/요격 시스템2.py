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
    public int solution(int[][] targets) {
        int ans = 0;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int prev = -1;
        for (int[] target : targets) {
            int s = target[0], e = target[1];

            if (prev < s) {
                ans++;
                prev = e - 1;
            }
        }

        return ans;
    }
}

'''



