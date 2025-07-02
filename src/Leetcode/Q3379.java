package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3379 {
    class Solution {
        public int[] constructTransformedArray(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i=0; i<n; i++) {
                ans[i] = nums[(n + i + (nums[i] % n)) % n];
            }
            return ans;
        }
    }
}
