# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        for (long time:times) right = Math.max(right, time);
        right *= n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (int time : times) total += mid / time;

            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}


'''


def solution(n, times):
    left, right = 1, n*max(times)
    while left < right:
        mid = (left+right)//2
        if sum([mid//t for t in times]) < n:
            left = mid+1
        else:
            right = mid
    return left

