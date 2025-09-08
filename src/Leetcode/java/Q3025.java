package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3025 {
    class Solution {
        public int numberOfPairs(int[][] points) {
            int n = points.length;
            int ans = 0;

            for (int i=0; i<n; i++) {
                int leftX = points[i][0], leftY = points[i][1];
                for (int j=0; j<n; j++) {
                    if (i == j) continue;
                    int rightX = points[j][0], rightY = points[j][1];
                    if (leftX > rightX || leftY < rightY) continue;

                    boolean included = false;
                    for (int k=0; k<n; k++) {
                        if (k==i || k==j) continue;
                        int midX = points[k][0], midY = points[k][1];
                        if (midX < leftX
                                || midX > rightX
                                || midY > leftY
                                || midY < rightY) {

                        } else {
                            included = true;
                            break;
                        }
                    }

                    if (!included) ans++;
                }
            }
            return ans;
        }
    }
}
