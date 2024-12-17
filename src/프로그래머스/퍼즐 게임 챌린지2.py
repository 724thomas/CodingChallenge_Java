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
    public long calcTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;
        totalTime += times[0];

        for (int i = 1; i < diffs.length; i++) {
            int D = diffs[i];
            int T = times[i];
            if (D <= level) {
                totalTime += T;
            } else {
                int failCount = D - level;
                long prevTime = times[i-1];
                long cost = failCount * ((long)T + prevTime) + T;
                totalTime += cost;
            }
        }
        return totalTime;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right =100000;


        // 이진 탐색
        while (left < right) {
            int mid = (left + right) / 2;
            long time = calcTime(diffs, times, mid);
            if (time <= limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

'''



