package Leetcode.java;

/*
1. 아이디어 :
- 브루트 포스

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
-
 */

public class Q1385 {
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int n = arr1.length;
            int m = arr2.length;
            int ans = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if ( Math.abs(arr1[i] - arr2[j]) <= d) {
                        break;
                    }
                    if (j==m-1) ans++;
                }
            }
            return ans;
        }
    }
}
