package Leetcode;

public class Q2380 {
    class Solution {
        public int secondsToRemoveOccurrences(String s) {
            int count = 0;
            while (s.contains("01")) {
                s = s.replaceAll("01", "10");
                count++;
            }
            return count;
        }
    }
}
