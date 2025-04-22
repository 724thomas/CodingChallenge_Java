package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3162 {
    class Solution {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            int ans = 0;
            for (int num1 : nums1) for (int num2 : nums2) if (num1 % (num2*k) == 0) ans++;
            return ans;
        }
    }
}
