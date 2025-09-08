package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3095 {
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length, ans = Integer.MAX_VALUE;
            for (int i=0; i<n; i++) {
                int curr = nums[i];
                int count = 1;
                if (curr >= k) return count;
                for (int j=i+1; j<n; j++) {
                    curr = curr | nums[j];
                    count++;
                    if (curr >= k) ans = Math.min(ans, count);
                }
            }
            return ans == Integer.MAX_VALUE? -1 : ans;
        }
    }
}
