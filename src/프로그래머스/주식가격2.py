# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    Monotonic Stack을 사용
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    Stack

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>(); // index, value

        for (int i=0; i<n; i++) {
            int currPrice = prices[i];
            while (!stack.isEmpty() && stack.peek()[1] > currPrice) {
                int prevIdx = stack.pop()[0];
                ans[prevIdx] = i - prevIdx;
            }
            stack.add(new int[]{i, currPrice});
        }

        while (!stack.isEmpty()) {
            int prevIdx = stack.pop()[0];
            ans[prevIdx] = n - prevIdx -1;
        }
        return ans;
    }
}

'''


def solution(prices):
    n = len(prices)
    ans = [0] * n
    stack = []  # (index, value)

    for i in range(n):
        curr_price = prices[i]
        while stack and stack[-1][1] > curr_price:
            prev_idx, _ = stack.pop()
            ans[prev_idx] = i - prev_idx
        stack.append((i, curr_price))

    while stack:
        prev_idx, _ = stack.pop()
        ans[prev_idx] = n - prev_idx - 1

    return ans
