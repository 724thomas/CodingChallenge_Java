package Leetcode.java;

import java.util.Stack;

public class Q921 {
    class Solution {
        public int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (var c : s.toCharArray()) {
                if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
            return stack.size();
        }
    }
}
