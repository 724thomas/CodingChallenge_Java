package Leetcode.java;

public class Q1475 {
    class Solution {
        public int[] finalPrices(int[] prices) {
            int N = prices.length;
            int[] ans = new int[N];
            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                    if (prices[j] <= prices[i]) {
                        prices[i] -= prices[j];
                        break;
                    }
                }
                ans[i] = prices[i];
            }
            return ans;
        }
    }
}
