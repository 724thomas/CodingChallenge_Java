package Leetcode.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q439 {
    class Solution {
        public String parseTernary(String expression) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = expression.length() -1; i > -1; i--) {
                char curr = expression.charAt(i);

                if (curr== '?') {
                    char trueResult = stack.pop();
                    char falseResult = stack.pop();
                    char condition = expression.charAt(--i);

                    if (condition == 'T') {
                        stack.push(trueResult);
                    } else {
                        stack.push(falseResult);
                    }
                }
                else if (curr != ':') {
                    stack.push(curr);
                }
                System.out.println(curr + " " + stack);
            }
            return String.valueOf(stack.pop());
        }
    }
}
