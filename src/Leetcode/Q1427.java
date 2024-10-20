package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q1427 {
    class Solution {
        public String stringShift(String s, int[][] shifts) {
            Deque<Character> deque = new LinkedList<>();
            for (int i=0; i<s.length(); i++){
                deque.addLast(s.charAt(i));
            }
            for (var shift : shifts){
                int dir = shift[0];
                int amount = shift[1];
                for (int i=0; i<amount; i++) {
                    if (dir == 0) {
                        deque.addLast(deque.pollFirst());
                    } else {
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (var c : deque) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
