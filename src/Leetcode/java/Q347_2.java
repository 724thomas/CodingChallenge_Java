package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347_2 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> pq =
                    new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

            pq.addAll(map.keySet());

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll();
            }

            return ans;
        }
    }

}
