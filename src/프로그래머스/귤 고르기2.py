# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int t : tangerine) {
            counter.put(t, counter.getOrDefault(t, 0)+1);
        }

        int[][] arr = new int[counter.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            arr[idx][0] = entry.getKey();
            arr[idx][1] = entry.getValue();
            idx++;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));

        int kinds = 0;
        for (int[] count : arr) {
            kinds ++;
            k -= count[1];
            if (k<=0) {
                return kinds;
            }
        }
        return arr.length;
    }
}

'''


