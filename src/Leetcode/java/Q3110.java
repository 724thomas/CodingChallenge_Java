package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3110 {
    class Solution {
        public int scoreOfString(String s) {
            int ans = 0;
            for (int i=0; i<s.length()-1; i++) {
                ans += Math.abs((int)s.charAt(i) - (int)s.charAt(i+1));
            }

            return ans;
        }
    }
}
