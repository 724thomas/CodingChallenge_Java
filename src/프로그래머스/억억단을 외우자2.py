# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    /*
    e 100
    1 * 100
    2 * 50
    3 * 33
    4 * 25
    5 * 20
    6 * 16
    7 * 14
    8 * 12
    9 * 11
    ...
    total < nlogn
    */

    public int[] solution(int e, int[] starts) {
        int[] counts = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                counts[j]++;
            }
        }

        int[] mostFrequent = new int[e + 1];
        int maxCount = 0;
        int minValue = 0;

        for (int i = e; i >= 1; i--) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                minValue = i;
            } else if (counts[i] == maxCount) {
                minValue = Math.min(minValue, i);
            }
            mostFrequent[i] = minValue;
        }

        int[] ans = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            ans[i] = mostFrequent[starts[i]];
        }
        return ans;
    }
}
'''



