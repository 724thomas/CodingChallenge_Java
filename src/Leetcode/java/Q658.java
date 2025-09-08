package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q658 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ans = new ArrayList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (Math.abs(a[0]-x) == Math.abs(b[0]-x)) return a[1]-b[1];
                return Math.abs(a[0]-x) - Math.abs(b[0]-x);
            });

            for (int i=0; i<arr.length; i++) {
                pq.add(new int[]{arr[i], i});
            }

            for (int i=0; i<k; i++) {
                ans.add(pq.poll()[0]);
            }
            Collections.sort(ans);
            return ans;
        }
    }
}
