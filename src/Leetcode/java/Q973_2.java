package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q973_2 {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]); // distance, x, y
            for (int point[] : points) {
                pq.add(new int[]{(int)Math.pow(point[0], 2) + (int)Math.pow(point[1],2), point[0], point[1]});
            }
            List<int[]> candids = new ArrayList<>();
            for (int i=0; i<k; i++) {
                int[] candid = pq.poll();
                candids.add(new int[]{candid[1], candid[2]});
            }

            int[][] ans = new int[candids.size()][2];
            for (int i=0; i<ans.length; i++) {
                ans[i] = candids.get(i);
            }
            return ans;
        }
    }
}
