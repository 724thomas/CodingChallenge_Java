package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3131 {
    class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            int cmin1 = Integer.MAX_VALUE, cmin2 = Integer.MAX_VALUE;
            for (int i=0; i<nums1.length; i++) {
                cmin1 = Math.min(cmin1, nums1[i]);
                cmin2 = Math.min(cmin2, nums2[i]);
            }
            return cmin2 - cmin1;
        }
    }
}
