# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    우선순위 큐
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer((long) s);

        while (pq.size() > 1 && pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            ans++;
        }

        return pq.peek() >= K ? ans : -1;
    }
}


'''


import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    ans = 0
    while len(scoville) > 1 and scoville[0] < K:
        heapq.heappush(scoville, heapq.heappop(scoville) + heapq.heappop(scoville)*2)
        ans+=1
    return -1 if scoville[0] < K else ans