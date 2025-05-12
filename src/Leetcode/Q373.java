package Leetcode;

/*
1. 아이디어 :
2차원 배열(int[][] sums)로 nums1 * nums2를 만들게되면, 시간초과
sums[i][0]을 nums1[i] 만큼 우선순위큐pq에 넣습니다. (total, row, col). total 기준으로 오름차순.
pq에서 가장 작은 값을 빼고, ans에 추가합니다.
가장 작은 값의 col+1 값을 pq에 더합니다.

2. 시간복잡도 :
O( Math.max(n,k) * logn)

3. 자료구조/알고리즘 :
우선순위큐 / -
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int n = nums1.length, m = nums2.length;
            List<List<Integer>> ans = new ArrayList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]); //total, row, col
            for (int row = 0; row<n; row++) {
                pq.add(new int[]{nums1[row]+ nums2[0], row, 0});
            }

            while (ans.size() < k) {
                int[] smallest = pq.poll();
                int row = smallest[1], col = smallest[2];
                ans.add(List.of(nums1[row], nums2[col]));
                if (col<m-1) {
                    pq.add(new int[]{nums1[row] + nums2[col+1], row, col+1});
                }
            }
            return ans;
        }
    }
}
