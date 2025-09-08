package Leetcode.java;

public class Q2028 {
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int totalRolls = rolls.length + n;
            int total = mean * totalRolls;
            int sumRolls = 0;
            for (int roll : rolls){
                sumRolls+=roll;
            }

            int needed = total - sumRolls;
            if (needed > 6 * n || needed/n <= 0) return new int[]{};

            int[] ans = new int[n];
            int idx = 0;
            while (n>0) {
                int temp = needed/n;
                ans[idx++] = needed/n;
                needed -= temp;
                n--;
            }
            return ans;
        }
    }
}
