package Leetcode;

public class Q1231 {
    class Solution {
        int[] sweetness;
        int k;

        public boolean splitable(int target) {
            int curr = 0;
            int cuts = 0;

            for (int s : sweetness) {
                curr += s;
                if (curr >= target) {
                    cuts++;
                    curr=0;
                }
            }
            return cuts >= k+1;
        }

        public int maximizeSweetness(int[] sweetness, int k) {
            this.sweetness=sweetness;
            this.k=k;

            int left = 1, right=0;
            for (int s:sweetness) right+=s;

            int ans = 0;
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (splitable(mid)) {
                    ans = mid;
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }

            return ans;
        }
    }
}
