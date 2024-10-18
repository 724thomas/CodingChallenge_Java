# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> deque = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for (int i = 0; i < priorities.length; i++) {
            deque.offer(new int[] {i, priorities[i]});
            pq.offer(priorities[i]);
        }

        int count = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();

            if (curr[1] == pq.peek()) {
                count++;
                pq.poll();
                if (curr[0] == location) return count;
            } else {
                deque.offer(curr);
            }
        }

        return -1;
    }
}


'''


