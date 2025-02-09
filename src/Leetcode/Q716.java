package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q716 {

    public class MaxStack {
        Deque<int[]> stack;
        PriorityQueue<int[]> maxHeap;
        Map<Integer, Integer> counter;
        int nextId;

        public MaxStack() {
            stack = new ArrayDeque<>();
            maxHeap = new PriorityQueue<>((a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);
            counter = new HashMap<>();
            nextId = 0;
        }

        public void push(int x) {
            stack.push(new int[]{x, nextId});
            maxHeap.offer(new int[]{x, nextId});
            nextId--;
        }

        public void cleanUp() {
            while (!stack.isEmpty() && counter.getOrDefault(stack.peek()[1], 0) > 0) {
                int id = stack.pop()[1];
                counter.put(id, counter.get(id) - 1);
                if (counter.get(id) == 0) {
                    counter.remove(id);
                }
            }
            while (!maxHeap.isEmpty() && counter.getOrDefault(maxHeap.peek()[1], 0) > 0) {
                int id = maxHeap.poll()[1];
                counter.put(id, counter.get(id) - 1);
                if (counter.get(id) == 0) {
                    counter.remove(id);
                }
            }
        }

        public int pop() {
            int[] entry = stack.pop();
            counter.put(entry[1], counter.getOrDefault(entry[1], 0) + 1);
            cleanUp();
            return entry[0];
        }

        public int top() {
            return stack.peek()[0];
        }

        public int peekMax() {
            return maxHeap.peek()[0];
        }

        public int popMax() {
            int[] entry = maxHeap.poll();
            counter.put(entry[1], counter.getOrDefault(entry[1], 0) + 1);
            cleanUp();
            return entry[0];
        }
    }
}
