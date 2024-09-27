# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Set<Integer> toBeRemoved = new HashSet<>();

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{i, stones[i]});
        }

        int ans = pq.peek()[1];

        for (int right = k; right < stones.length; right++) {
            pq.offer(new int[]{right, stones[right]});
            toBeRemoved.add(right - k);

            while (toBeRemoved.contains(pq.peek()[0])) {
                pq.poll();
            }
            ans = Math.min(ans, pq.peek()[1]);
        }
        return ans;
    }
}

'''


