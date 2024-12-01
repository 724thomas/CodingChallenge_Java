package Leetcode;

public class Q2170 {
    class Solution {
        public int minimumOperations(int[] nums) {
            int n = nums.length;
            int maxVal = 100001;
            int[][] counter = new int[maxVal][2];

            for (int i = 0; i < n; i++) counter[nums[i]][i % 2]++;

            int evenMax1 = 0, evenMax2 = 0, evenVal1 = 0, evenVal2 = 0;
            int oddMax1 = 0, oddMax2 = 0, oddVal1 = 0, oddVal2 = 0;

            for (int i = 0; i < maxVal; i++) {
                if (counter[i][0] > evenMax1) {
                    evenMax2 = evenMax1;
                    evenVal2 = evenVal1;
                    evenMax1 = counter[i][0];
                    evenVal1 = i;
                } else if (counter[i][0] > evenMax2) {
                    evenMax2 = counter[i][0];
                    evenVal2 = i;
                }

                if (counter[i][1] > oddMax1) {
                    oddMax2 = oddMax1;
                    oddVal2 = oddVal1;
                    oddMax1 = counter[i][1];
                    oddVal1 = i;
                } else if (counter[i][1] > oddMax2) {
                    oddMax2 = counter[i][1];
                    oddVal2 = i;
                }
            }

            return evenVal1 != oddVal1? n - evenMax1 - oddMax1: n - Math.max(evenMax1 + oddMax2, evenMax2 + oddMax1);
        }
    }

}
