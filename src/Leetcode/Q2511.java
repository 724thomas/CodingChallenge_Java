package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2511 {
    class Solution {
        public int captureForts(int[] forts) {
            int n = forts.length;

            int ans = 0;
            int curr = -n;
            boolean found = false;
            for (int i=0; i<n; i++) {
                if (forts[i] == 1) {
                    found = true;
                    curr = 0;
                }

                if (forts[i] == 0 && found) {
                    curr++;
                }

                if (forts[i] == -1) {
                    if (found) {
                        ans = Math.max(ans, curr);
                    }
                    curr = 0;
                    found = false;
                }
            }

            curr = -n;
            found = false;
            for (int i=n-1; i>-1; i--) {
                if (forts[i] == 1) {
                    found = true;
                    curr = 0;
                }

                if (forts[i] == 0 && found) {
                    curr++;
                }

                if (forts[i] == -1) {
                    if (found) {
                        ans = Math.max(ans, curr);
                    }
                    curr = 0;
                    found = false;
                }
            }
            return ans;
        }
    }
}
