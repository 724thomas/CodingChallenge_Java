package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class Q155 {
    class MinStack {
        TreeMap<Integer, Integer> treeMap;
        Deque<Integer> deque;
        public MinStack() {
            treeMap = new TreeMap<>();
            deque = new ArrayDeque<>();
        }

        public void push(int val) {
            deque.addLast(val);
            treeMap.put(val, treeMap.getOrDefault(val, 0)+1);
        }

        public void pop() {
            int val = deque.pollLast();
            treeMap.put(val, treeMap.get(val)-1);
            if (treeMap.get(val)==0) treeMap.remove(val);
        }

        public int top() {
            return deque.peekLast();
        }

        public int getMin() {
            return treeMap.firstKey();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
