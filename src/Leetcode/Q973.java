package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q973 {
    class Solution {
        public int[] getDistance(int[] cords) {
            return new int[]{(int)(Math.pow(cords[0], 2) + Math.pow(cords[1],2)), cords[0], cords[1]};
        }
        public int[][] kClosest(int[][] points, int k) {
            int[][] ans = new int[k][2];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
            for (int[] point : points) pq.add(getDistance(point));
            for (int i=0; i<k; i++) {
                int[] point = pq.poll();
                ans[i] = new int[]{point[1], point[2]};
            }
            return ans;
        }
    }
}
