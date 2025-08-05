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

public class Q347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                counter.put(num, counter.getOrDefault(num, 0)+1);
            }

            int[] ans = new int[k];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
            for (var entry : counter.entrySet()) {
                int key = entry.getKey(), val = entry.getValue();
                pq.add(new int[]{key, val});
            }

            for (int i=0; i<k; i++) {
                ans[i] = pq.poll()[0];
            }
            return ans;
        }
    }
}
