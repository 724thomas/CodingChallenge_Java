package Leetcode.java;

public class Q3340 {
    class Solution {
        public boolean isBalanced(String num) {
            int[] sums = new int[2];
            char[] charNum = num.toCharArray();
            for (int i=0; i<num.length(); i++) {
                sums[i%2] += Integer.parseInt(charNum[i]+"");
            }
            return sums[0] == sums[1];
        }
    }
}
