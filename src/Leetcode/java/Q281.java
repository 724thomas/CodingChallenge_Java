package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Q281 {
    public class ZigzagIterator {
        Queue<Integer> queue;
        int n;
        int idx;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            queue = new ArrayDeque<>();
            n = Math.max(v1.size(), v2.size());
            idx=0;

            for (int i=0; i<n; i++) {
                if (i<v1.size()) queue.add(v1.get(i));
                if (i<v2.size()) queue.add(v2.get(i));
            }

        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
