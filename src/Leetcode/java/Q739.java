package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Deque<int[]> deque = new ArrayDeque<>();
            int[] ans = new int[n];

            for (int i=0; i<n; i++) {
                while (!deque.isEmpty() && deque.peekLast()[0] < temperatures[i]) {
                    int prevIdx = deque.pollLast()[1];
                    ans[prevIdx] = i - prevIdx;
                }
                deque.add(new int[]{temperatures[i], i});
            }
            return ans;
        }
    }
}
