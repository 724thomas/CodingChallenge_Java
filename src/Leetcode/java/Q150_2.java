package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
Deque
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150_2 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> deque = new ArrayDeque<>();

            for (String token : tokens) {
                if (token.equals("+")) {
                    int prev = deque.pollLast();
                    int pprev = deque.pollLast();
                    deque.add(pprev + prev);
                } else if (token.equals("-")) {
                    int prev = deque.pollLast();
                    int pprev = deque.pollLast();
                    deque.add(pprev - prev);
                } else if (token.equals("*")) {
                    int prev = deque.pollLast();
                    int pprev = deque.pollLast();
                    deque.add(pprev * prev);
                } else if (token.equals("/")) {
                    int prev = deque.pollLast();
                    int pprev = deque.pollLast();
                    deque.add(pprev / prev);
                } else {
                    int num = Integer.parseInt(token);
                    deque.add(num);
                }
            }

            return deque.pollFirst();
        }
    }
}
