package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q875_2 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 0;
            for (int pile : piles) right = Math.max(right, pile);

            while (left <= right) {
                int mid = left + (right - left) / 2;

                boolean possible = canEat(piles, h, mid);
                if (possible) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean canEat(int[] piles, int h, int k) {
            int total = 0;
            for (int pile : piles) {
                total += (pile + k - 1)/ k;
                if (total > h) return false;
            }
            return true;
        }
    }
}
