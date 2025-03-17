package Leetcode;

/*
1. 아이디어 :
이분탐색을 사용합니다.
mid를 기준으로 위에 있는 사각형과 아래에 있는 사각형의 넓이를 구합니다.
정확도는 10^-5이기때문에 60번정도만 반복하면 됩니다.

2. 시간복잡도 :
O( 60n)

3. 자료구조/알고리즘 :
- / 이분탐색
 */

public class Q3453 {
    class Solution {
        public double check(double mid, int[][] squares) {
            double above = 0, below = 0;
            for (int i=0; i<squares.length; i++) {
                int x = squares[i][0], y = squares[i][1], l = squares[i][2];
                double total = (double) l*l;

                if (mid <= y) {
                    above += total;
                } else if (mid >= y+l) {
                    below += total;
                } else {
                    double aHeight = (y+l) - mid;
                    double bHeight = mid - y;
                    above += l * aHeight;
                    below += l * bHeight;
                }
            }
            return above - below;
        }
        public double separateSquares(int[][] squares) {
            double left = 0, right = 2_000_000_000;

            for (int i=0; i<60; i++) {
                double mid = left + (right-left)/2;
                double diff = check(mid, squares);

                if (diff > 0) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            return right;
        }
    }
}
