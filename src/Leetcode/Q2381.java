package Leetcode;

public class Q2381 {
    class Solution {
        public char shift(char c, int move) {
            move = (move%26 + 26) % 26;
            return (char) ('a' + (c - 'a' + move) % 26);
        }

        public String shiftingLetters(String s, int[][] shifts) {
            int[] prefixSum = new int[s.length()+1];
            for (int[] shift : shifts) {
                int start = shift[0], end = shift[1];
                if (shift[2] == 0) {
                    prefixSum[start]--;
                    prefixSum[end+1]++;
                } else {
                    prefixSum[start]++;
                    prefixSum[end+1]--;
                }
            }
            for (int i=1; i<prefixSum.length; i++) prefixSum[i] += prefixSum[i-1];

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<prefixSum.length-1; i++) {
                sb.append(shift(s.charAt(i),prefixSum[i]));
            }

            return sb.toString();

        }
    }
}
