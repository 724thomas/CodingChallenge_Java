package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3034 {
    class Solution {
        int[] pattern;
        int[] nums;
        int n, m;
        public boolean check(int idx) {
            for (int i=0; i<m; i++) {
                if (pattern[i] == 1) {
                    if (nums[i+idx+1] <= nums[i+idx]) return false;
                } else if (pattern[i] == 0) {
                    if (nums[i+idx+1] != nums[i+idx]) return false;
                } else {
                    if (nums[i+idx+1] >= nums[i+idx]) return false;
                }
            }
            return true;
        }

        public int countMatchingSubarrays(int[] nums, int[] pattern) {
            this.pattern = pattern;
            this.nums = nums;
            n = nums.length;
            m = pattern.length;
            int ans = 0;

            for (int i=0; i<n-m; i++) {
                if (check(i)) ans++;
            }

            return ans;
        }
    }
}
