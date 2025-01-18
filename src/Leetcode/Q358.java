package Leetcode;

import java.util.*;

public class Q358 {
    class Solution {

        public String rearrangeString(String s, int k) {
            if (k==0) return s;
            Map<Character, Integer> counter = new HashMap<>();
            for (char c : s.toCharArray()) counter.put(c, counter.getOrDefault(c, 0)+1);

            int maxCount = 0;
            for (int value: counter.values()) maxCount = Math.max(maxCount, value);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]); //counter, char
            Queue<int[]> queue = new ArrayDeque<>(); // cooldown, counter, char

            for (var entry: counter.entrySet()) {
                pq.add(new int[]{entry.getValue(), entry.getKey()-'a'});
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (!queue.isEmpty() && queue.peek()[0] == i) {
                    int[] queuef = queue.poll();
                    pq.add(new int[]{queuef[1], queuef[2]});
                }
                if (pq.isEmpty()) return "";
                int[] pqf = pq.poll();
                int count = pqf[0];
                char c = (char)(pqf[1]+'a');

                sb.append(c);
                if (count != 1) queue.add(new int[]{i+k, count-1, pqf[1]});
            }

            return sb.toString();
        }
    }
}
