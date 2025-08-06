package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150 {
    class Solution {
        public boolean isOperator(String token) {
            return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
        }
        public int evalRPN(String[] tokens) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (String token : tokens) {
                if (token.equals("+")) {
                    int num2 = deque.pollLast(), num1 = deque.pollLast();
                    deque.add(num1 + num2);
                } else if (token.equals("-")) {
                    int num2 = deque.pollLast(), num1 = deque.pollLast();
                    deque.add(num1 - num2);
                } else if (token.equals("*")) {
                    int num2 = deque.pollLast(), num1 = deque.pollLast();
                    deque.add(num1 * num2);
                } else if (token.equals("/")) {
                    int num2 = deque.pollLast(), num1 = deque.pollLast();
                    deque.add(num1 / num2);
                } else {
                    deque.add(Integer.parseInt(token));
                }
            }
            return deque.pollFirst();
        }
    }
}
