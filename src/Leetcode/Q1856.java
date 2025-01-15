package Leetcode;

import java.util.PriorityQueue;

public class Q1856 {
    class Solution {
        public int maxSumMinProduct(int[] nums) {
            long ans = 0;
            int n = nums.length;

            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            }); // val desc, idx desc

            for (int ci = 0; ci < n; ci++) {
                int cnum = nums[ci];
                int pqidx = ci;

                while (!pq.isEmpty() && pq.peek()[1] > cnum) {
                    int[] prev = pq.poll();
                    int pi = prev[0], pnum = prev[1];

                    long subarraySum = prefix[ci] - prefix[pi];
                    ans = Math.max(ans, subarraySum * pnum);

                    pqidx = pi;
                }

                pq.add(new int[]{pqidx, cnum});
            }

            while (!pq.isEmpty()) {
                int[] prev = pq.poll();
                int pi = prev[0], pnum = prev[1];

                long subarraySum = prefix[n] - prefix[pi];
                ans = Math.max(ans, subarraySum * pnum);
            }

            return (int) (ans % 1_000_000_007);
        }
    }

}
