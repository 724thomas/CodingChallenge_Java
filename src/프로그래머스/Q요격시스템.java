package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q요격시스템 {

    class Solution {
        public int solution(int[][] targets) {
            int n = targets.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (Integer.compare(a[1], b[1]) == 0) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            for (int[] target : targets) {
                pq.add(target);
            }

            int ans = 0;
            while (!pq.isEmpty()) {
                int[] c = pq.poll();
                int start = c[0], end = c[1];
                while (!pq.isEmpty() && pq.peek()[0] < end) {
                    pq.poll();
                }
                ans++;
            }

            return ans;
        }
    }
}
