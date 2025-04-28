package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1663 {
    class Solution {
        public String getSmallestString(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int maxK = 26 * n;
            for (int i=0; i<n; i++) {
                int diff = Math.min(25, maxK - k);
                sb.append((char) ('a' + 25-diff));
                maxK -= diff;
            }
            return sb.toString();
        }
    }
}
