package Leetcode;

public class Q2833 {
    class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int spaces = 0, ans = 0;
            for (char move : moves.toCharArray()) {
                if (move=='L') ans++; else if (move=='R') ans--; else spaces++;
            }

            return Math.abs(ans) + spaces;
        }
    }
}
