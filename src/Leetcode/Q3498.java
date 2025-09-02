package Leetcode;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q3498 {
    class Solution {
        public int reverseDegree(String s) {
            int n = s.length(), ans = 0;
            for (int i=0; i<n; i++) {
                ans += (i+1) * (26 - (s.charAt(i) - 'a'));
            }
            return ans;
        }
    }
}
