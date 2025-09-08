package Leetcode.java;

public class Q2340 {
    class Solution {
        public int minimumSwaps(int[] nums) {
            int n = nums.length;
            int cminIdx = 0, cmaxIdx = 0;
            int cmin = Integer.MAX_VALUE, cmax = 0;
            for (int i=0; i<n; i++) {
                int num = nums[i];
                if (num < cmin) {
                    cminIdx = i;
                    cmin = num;
                }
                if (num >= cmax) {
                    cmaxIdx = i;
                    cmax = num;
                }
            }
            int ans = 0;
            if (cminIdx == 0 && cmaxIdx == n-1) return ans;
            if (cminIdx > cmaxIdx) ans--;
            ans += cminIdx;
            ans += n - cmaxIdx - 1;
            return ans;
        }
    }
}
