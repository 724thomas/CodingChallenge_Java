# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    큐를 사용
2. 시간복잡도 :
    O(n*m)
3. 자료구조 :
    큐

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<bridge_length; i++) deque.addLast(0);

        int arrived = 0;
        int time = 0;
        int currWeight = 0;
        int idx = 0;

        while (arrived != truck_weights.length) {
            if (deque.peekFirst() != 0) arrived++;
            currWeight -= deque.pollFirst();


            if (idx < truck_weights.length && truck_weights[idx] <= weight - currWeight) {
                deque.addLast(truck_weights[idx]);
                currWeight += truck_weights[idx];
                idx++;
            } else {
                deque.addLast(0);
            }

            time ++;

        }
        return time;
    }
}
'''



