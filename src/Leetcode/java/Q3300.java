package Leetcode.java;

public class Q3300 {
    class Solution {
        public int getSum(int num) {
            String snum = String.valueOf(num);
            int total = 0;
            for (int i=0; i<snum.length(); i++) {
                total += Integer.parseInt(snum.charAt(i)+"");
            }
            return total;
        }
        public int minElement(int[] nums) {
            int ans = Integer.MAX_VALUE;
            for (int num : nums) {
                ans = Math.min(ans, getSum(num));
            }
            return ans;
        }
    }
}
