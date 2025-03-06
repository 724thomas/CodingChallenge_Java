package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1608 {
    class Solution {
        public int specialArray(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> counter = new HashMap<>();
            int cmax = 0;
            for (int num:nums) {
                counter.put(num, counter.getOrDefault(num, 0)+1);
                cmax = Math.max(cmax, num);
            }

            int total = n;
            for (int i=0; i<cmax+1; i++) {
                if (total == i) return i;
                total -= counter.getOrDefault(i, 0);
            }

            return -1;
        }
    }
}
