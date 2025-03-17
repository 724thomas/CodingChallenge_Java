package Leetcode;

/*
1. 아이디어 :
diag길이와 area를 구하는 메서드를 통해 가장 길고 큰 값을 찾습니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q3000 {
    class Solution {
        public int getDiag(int l, int w) {
            return l*l + w*w;
        }
        public int getArea(int l, int w) {
            return l*w;
        }
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int mArea = 0;
            int mLongest = 0;
            for (int[] d : dimensions) {
                int diag = getDiag(d[0], d[1]), area = getArea(d[0], d[1]);
                if (diag > mLongest) {
                    mLongest = diag;
                    mArea = area;
                }
                else if (diag == mLongest) {
                    mArea = Math.max(mArea, area);
                }
            }
            return mArea;
        }
    }
}
