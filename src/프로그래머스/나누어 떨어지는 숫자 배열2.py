# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :

import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> candids = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) candids.add(num);
        }
        if (candids.isEmpty()) return new int[]{-1};
        Collections.sort(candids);
        return candids.stream().mapToInt(Integer::intValue).toArray();
    }
}
'''



