# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int front = 1;

        for (int toBeLoaded : order) {
            if (front <= toBeLoaded) {
                while (front < toBeLoaded) {
                    stack.push(front);
                    front++;
                }
                front++;
                ans++;
            } else {
                if (!stack.isEmpty() && stack.pop() == toBeLoaded){
                    ans++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
'''


def solution(order):
    stack, ans, front = [], 0, 1

    for tobeloaded in order:
        if front <=tobeloaded:
            while front < tobeloaded:
                stack.append(front)
                front+=1
            front+=1
            ans+=1
        else:
            if stack and stack.pop() == tobeloaded:
                ans+=1
            else:
                return ans
    return ans