package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1712 {
    class Solution {
        int MOD = 1_000_000_007;
        int n;
        int[] prefix;
        public int getMinIdx(int idx) {
            int left = idx+1, right = n-2, first = -1;
            int leftVal = prefix[idx];
            while (left <= right) {
                int mid = left + (right-left)/2;
                int midVal = prefix[mid] - prefix[idx];

                if (leftVal <= midVal) {
                    first = mid;
                    right = mid-1;
                } else {
                    left = mid +1;
                }
            }
            return first;
        }

        public int getMaxIdx(int idx, int first) {
            if (first == -1) return -1;
            int left = first, right = n-2, last = -1;

            while (left <= right) {
                int mid = left + (right-left)/2;
                int midVal = prefix[mid] - prefix[idx];
                int rightVal = prefix[n-1] - prefix[mid];

                if (midVal <= rightVal) {
                    last = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return last;
        }
        public int waysToSplit(int[] nums) {
            n = nums.length;
            prefix = new int[n];
            prefix[0] = nums[0];
            for (int i=1; i<n; i++) prefix[i] = prefix[i-1] + nums[i];

            int ans = 0;
            for (int i=0; i<n-2; i++) {
                int first = getMinIdx(i);
                int last = getMaxIdx(i, first);
                if (last != -1) {
                    ans = (ans + (last - first + 1)) % MOD;
                }
            }

            return ans;
        }
    }
}
