package Leetcode.java;

public class Q1228 {
    class Solution {
        public int missingNumber(int[] arr) {
            int actualDiff = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                int diff = arr[i] - arr[i-1];
                if (diff != actualDiff) return arr[i]-actualDiff;
            }

            return arr[0];
        }
    }
}
