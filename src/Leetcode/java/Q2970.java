package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2970 {
    class Solution {
        int[] nums;
        int n;
        public boolean check(int start, int end) {
            int prev = Integer.MIN_VALUE;
            for (int i=0; i<n; i++) {
                if (start <= i && i <= end) continue;
                if (prev >= nums[i]) return false;
                prev = nums[i];
            }
            return true;
        }

        public int incremovableSubarrayCount(int[] nums) {
            this.nums = nums;
            n = nums.length;

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=i; j<n; j++) {
                if (check(i,j)) ans++;
            }
            return ans;
        }
    }
}
