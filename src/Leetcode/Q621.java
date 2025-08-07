package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            PriorityQueue<int[]> processQueue = new PriorityQueue<>((a, b) -> b[1]-a[1]); // String, count, time
            PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((a,b) -> a[2]-b[2]); // String, count, time

            Map<Character, Integer> counter = new HashMap<>();
            for (char task : tasks) counter.put(task, counter.getOrDefault(task, 0)+1);
            for (var entry : counter.entrySet()) {
                processQueue.add(new int[]{entry.getKey(), entry.getValue(), 0});
            }

            int time = 0;
            while (!processQueue.isEmpty() || !waitingQueue.isEmpty()) {
                time++;
                while (!waitingQueue.isEmpty() && waitingQueue.peek()[2] <= time) {
                    processQueue.add(waitingQueue.poll());
                }

                if (!processQueue.isEmpty()) {
                    int[] processed = processQueue.poll();
                    processed[1]--;
                    processed[2] = time+n+1;
                    if (processed[1] == 0) continue;
                    waitingQueue.add(processed);
                }
            }

            return time;
        }
    }
}
