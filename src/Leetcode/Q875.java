package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q875 {
    class Solution {
        int[] piles;
        int h;
        public boolean check(long speed) {
            int total = 0;
            for (int pile : piles) total += (int)Math.ceil((double)pile/speed);
            return total <= h;
        }
        public int minEatingSpeed(int[] piles, int h) {
            this.piles = piles;
            this.h = h;

            long total = 0;
            for (int pile :piles) total += pile;
            long left = 1, right = total;

            while (left <= right) {
                long mid = left + (right-left)/2;

                if (!check(mid)) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return (int)left;
        }
    }
}
