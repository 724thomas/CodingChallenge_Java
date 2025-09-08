package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q822 {
    class Solution {
        public int flipgame(int[] fronts, int[] backs) {
            int n = fronts.length;
            int ans = Integer.MAX_VALUE;

            for (int i=0; i<n; i++) {
                int front = fronts[i], back = backs[i];
                boolean dupFront = false, dupBack = false;
                for (int j=0; j<n; j++) {
                    if (front == fronts[j] && front == backs[j]) dupFront = true;
                    if (back == fronts[j] && back == backs[j]) dupBack = true;
                }
                if (!dupFront) ans = Math.min(ans, front);
                if (!dupBack) ans = Math.min(ans, back);
            }
            return ans == Integer.MAX_VALUE? 0 : ans;

        }
    }
}
