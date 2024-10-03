# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    deque를 사용해서 회전을 구현
    Stack을 사용해서 유효한지 확인
    스택이 비었는데 닫는게 들어오면 false
2. 시간복잡도 :
    O(n * n)
3. 자료구조 :
    Deque, Stack

import java.util.*;
class Solution {
    Deque<Character> deque = new LinkedList<>();
    Map<Character, Character> pairs = new HashMap<>();
    Stack<Character> stack;
    int ans = 0;

    public boolean check(Deque<Character> deque){
        stack = new Stack<>();
        for (var c : deque){
            if (stack.isEmpty() && pairs.containsKey(c)) return false;
            if (!stack.isEmpty() && stack.peek() == pairs.get(c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        pairs.put(']','[');
        pairs.put('}','{');
        pairs.put(')','(');
        for (var c : s.toCharArray()) deque.add(c);
        for (int i=0; i<s.length(); i++) {
            if (check(deque)) ans++;
            deque.addLast(deque.pollFirst());
        }
        return ans;
    }
}

'''


