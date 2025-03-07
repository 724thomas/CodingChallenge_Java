package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2499 {
    class Solution {
        public long minimumTotalCost(int[] nums1, int[] nums2) {
            Map<Integer, Integer> counter = new HashMap<>();
            int k=0, same=0, n=nums1.length;

            boolean[] checked = new boolean[n];
            long output = 0;
            for (int i=0; i<n; i++) {
                if (nums1[i] == nums2[i]) {
                    checked[i] = true;
                    counter.put(nums1[i], counter.getOrDefault(nums1[i], 0)+1);
                    same++;
                    output+=i;
                }
            }
            for (var count : counter.entrySet()) {
                if (count.getValue() > same/2) {
                    k = count.getKey();
                    break;
                }
            }

            if (k>0) {
                for (int i=0; i<n && counter.get(k) > same/2; i++) {
                    if (!checked[i] && nums1[i] != k && nums2[i] != k) {
                        same++;
                        checked[i] = true;
                        output += i;
                    }
                }
                if (counter.get(k) > same/2) return -1;
            }
            return output;
        }
    }
}
