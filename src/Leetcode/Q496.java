package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> biggerNum = new HashMap<>();

            int m = nums2.length;
            for (int i=0; i<m; i++) {
                int num = nums2[i];
                for (int j=i+1; j<m; j++) {
                    int num2 = nums2[j];
                    if (num < num2) {
                        biggerNum.put(num, num2);
                        break;
                    }
                }
            }

            int n = nums1.length;
            int[] ans = new int[n];
            int idx = 0;
            for (int num : nums1) {
                ans[idx++] = biggerNum.containsKey(num) ? biggerNum.get(num) : -1;
            }


            return ans;
        }
    }
}
