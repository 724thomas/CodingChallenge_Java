package Leetcode;

import java.util.PriorityQueue;

public class Q3040 {
    class Solution {
        public int maxOperations(int[] nums) {
            var n = nums.length;
            var maxOps = n/2;
            var ans = 1;

            var queue = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            queue.add(new int[]{1, 2, n-1, nums[0]+nums[1]}); //count, left, right, val
            queue.add(new int[]{1, 1, n-2, nums[0]+nums[n-1]});
            queue.add(new int[]{1, 0, n-3, nums[n-2]+nums[n-1]});
            var visited = new boolean[n+1][n+1];

            while (!queue.isEmpty()){
                var curr = queue.poll();
                var count = curr[0];
                var left = curr[1];
                var right = curr[2];
                var val = curr[3];
                // System.out.println(Arrays.toString(curr));

                ans = Math.max(ans, count);
                if (visited[left][right]) continue;
                visited[left][right] = true;

                if (count == maxOps) return ans;

                if (left + 1 <= right && nums[left] + nums[left + 1] == val) {
                    queue.add(new int[]{count + 1, left + 2, right, val});
                }
                if (left <= right - 1 && nums[left] + nums[right] == val) {
                    queue.add(new int[]{count + 1, left + 1, right - 1, val});
                }
                if (left <= right - 2 && nums[right] + nums[right - 1] == val) {
                    queue.add(new int[]{count + 1, left, right - 2, val});
                }
            }

            return ans;
        }
    }
}
