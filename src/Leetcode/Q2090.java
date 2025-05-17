package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2090 {
    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n];
            long total = 0;
            int left = n;
            int windowSize = 1 + 2*k;
            for (int i=0; i<n; i++) {
                if (i<k || n-k-1 < i) {
                    ans[i] = -1;
                    left--;
                }
            }
            if (left==0) return ans;

            for (int i=0; i<windowSize; i++) {
                total += nums[i];
            }

            for (int i=windowSize; i<n; i++) {
                ans[i-k-1] = (int)(total/windowSize);
                total -= nums[i-windowSize];
                total += nums[i];
            }
            ans[n-k-1] = (int)(total/windowSize);

            return ans;
        }
    }
}
