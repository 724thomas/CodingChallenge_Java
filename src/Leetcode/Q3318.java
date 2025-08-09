package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q3318 {
    class Solution {
        private int getTotal(Map<Integer, Integer> counter, int x) {
            List<int[]> counts = new ArrayList<>();
            for (var entry : counter.entrySet()) {
                counts.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(counts, (a, b) -> {
                if (Integer.compare(a[1], b[1]) == 0) return Integer.compare(b[0],a[0]);
                return Integer.compare(b[1],a[1]);
            });

            int total = 0;
            for (int i=0; i<Math.min(x, counts.size()); i++) {
                int[] count = counts.get(i);
                total += count[0] * count[1];
            }
            return total;
        }
        public int[] findXSum(int[] nums, int k, int x) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];

            Map<Integer, Integer> counter = new HashMap<>();
            for (int i=0; i<k; i++) {
                counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
            }
            ans[0] = getTotal(counter, x);

            for (int i=1; i<n-k+1; i++) {
                counter.put(nums[i-1], counter.get(nums[i-1])-1);
                counter.put(nums[i+k-1], counter.getOrDefault(nums[i+k-1],0)+1);
                ans[i] = getTotal(counter, x);
            }
            return ans;
        }
    }
}
