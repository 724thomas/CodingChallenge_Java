package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q3218 {
    class Pair {
        int val;
        boolean isHorizontal;

        public Pair(int val, boolean isHorizontal) {
            this.val=val;
            this.isHorizontal=isHorizontal;
        }
    }
    class Solution {
        public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            int horizontal = 1, vertical = 1;
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.val-a.val);
            for (int cut : horizontalCut) {
                pq.add(new Pair(cut, true));
            }
            for (int cut : verticalCut) {
                pq.add(new Pair(cut, false));
            }

            int ans = 0;
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int val = p.val;
                if (p.isHorizontal) {
                    horizontal++;
                    ans += vertical * val;
                } else {
                    vertical++;
                    ans+= horizontal * val;
                }
            }
            return ans;
        }
    }
}
