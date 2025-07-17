package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3561 {
    class Solution {
        public String resultingString(String s) {
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (!deque.isEmpty() && (Math.abs(deque.peekLast()-'a' - (c-'a')) == 1 || Math.abs(deque.peekLast()-'a' - (c-'a')) == 25)) {
                    deque.pollLast();
                } else {
                    deque.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) sb.append(deque.pollFirst());
            return sb.toString();
        }
    }
}
