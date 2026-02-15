package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q97 {

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length(), n2 = s2.length();
            if (n1 + n2 != s3.length()) return false;

            List<int[]> dp1 = new ArrayList<>();
            dp1.add(new int[]{0, 0});

            for (int k = 0; k < s3.length(); k++) {
                char c = s3.charAt(k);
                boolean[][] seen = new boolean[n1 + 1][n2 + 1];
                List<int[]> dp2 = new ArrayList<>();

                for (int[] candid : dp1) {
                    int x1 = candid[0], x2 = candid[1];

                    if (x1 < n1 && s1.charAt(x1) == c) {
                        int nx1 = x1 + 1, nx2 = x2;
                        if (!seen[nx1][nx2]) {
                            seen[nx1][nx2] = true;
                            dp2.add(new int[]{nx1, nx2});
                        }
                    }

                    if (x2 < n2 && s2.charAt(x2) == c) {
                        int nx1 = x1, nx2 = x2 + 1;
                        if (!seen[nx1][nx2]) {
                            seen[nx1][nx2] = true;
                            dp2.add(new int[]{nx1, nx2});
                        }
                    }
                }

                if (dp2.isEmpty()) return false;
                dp1 = dp2;
            }

            for (int[] candid : dp1) {
                if (candid[0] == n1 && candid[1] == n2) return true;
            }
            return false;
        }
    }

}
