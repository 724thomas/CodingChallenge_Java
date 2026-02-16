package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q739_2 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];

            Deque<int[]> stack = new ArrayDeque<>(); // temp, idx
            for (int i=0; i<n; i++) {
                int temperature = temperatures[i];

                while (!stack.isEmpty() && stack.getLast()[0] < temperature) {
                    int prevIdx = stack.pollLast()[1];
                    ans[prevIdx] = i - prevIdx;
                }
                stack.add(new int[]{temperature, i});
            }
            return ans;
        }
    }
}
