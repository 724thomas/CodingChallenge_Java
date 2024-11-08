# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    횟수가 적은 숫자부터 탐색.
2. 시간복잡도 :
    O(3nlogn)
3. 자료구조 :
    힙, 해시셋

import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> cache = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{x, 0});

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if (curr[0] == y) return curr[1];
            if (curr[0] * 3 <= y && !cache.contains(curr[0]*3)) {
                cache.add(curr[0] * 3);
                pq.offer(new int[]{curr[0]*3, curr[1]+1});
            }
            if (curr[0] * 2 <= y && !cache.contains(curr[0]*2)) {
                cache.add(curr[0] * 2);
                pq.offer(new int[]{curr[0]*2, curr[1]+1});
            }
            if (curr[0] + n <= y && !cache.contains(curr[0]+n)) {
                cache.add(curr[0] + n);
                pq.offer(new int[]{curr[0]+n, curr[1]+1});
            }
        }
        return -1;
    }
}
'''


import heapq
def solution(x, y, n):
    minheap = []
    visited = set()
    heapq.heappush(minheap, [0,x])

    while minheap:
        count, val = heapq.heappop(minheap)
        if val == y: return count
        nvals = [val*3, val*2, val+n]
        for nval in nvals:
            if nval<=y and nval not in visited:
                heapq.heappush(minheap, [count+1, nval])
                visited.add(nval)
    return -1