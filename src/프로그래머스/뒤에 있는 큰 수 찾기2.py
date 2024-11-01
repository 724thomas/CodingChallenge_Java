# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    Monotonic stack 사용
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    stack

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++){
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                ans[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }
        return ans;
    }
}

'''


def solution(numbers):
    ans = [-1] * len(numbers)
    stack = [] # index, value
    for i in range(len(numbers)):
        while stack and numbers[stack[-1]] < numbers[i]:
            ans[stack.pop()] = numbers[i]
        stack.append(i)
    return ans