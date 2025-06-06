package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2549 {
    class Solution {
        public int distinctIntegers(int n) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(n);
            boolean[] visited = new boolean[101];
            int ans = 0;

            while (!deque.isEmpty()) {
                int num = deque.pollFirst();
                if (visited[num]) continue;
                visited[num] = true;
                ans++;
                for (int i=1; i<=n; i++) {
                    if (num % i == 1) {
                        deque.add(i);
                    }
                }
            }
            return ans;
        }
    }
}
