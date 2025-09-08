package Leetcode.java;

public class Q3200 {
    class Solution {
        public int maxHeightOfTriangle(int red, int blue) {
            return Math.max(calculateHeight(red, blue), calculateHeight(blue, red));
        }

        private int calculateHeight(int r, int b) {
            int height = 0;
            boolean useRed = true;

            while (true) {
                int requiredBalls = height + 1;
                if (useRed && r >= requiredBalls) {
                    r -= requiredBalls;
                } else if (!useRed && b >= requiredBalls) {
                    b -= requiredBalls;
                } else {
                    break;
                }
                height++;
                useRed = !useRed;
            }

            return height;
        }
    }

}
