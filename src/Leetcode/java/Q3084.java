package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3084 {
    class Solution {
        public long countSubstrings(String s, char c) {
            long count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == c) {
                    count++;
                }
            }
            long ans = 0;
            for (int i=1; i<=count; i++) {
                ans += i;
            }

            return ans;
        }
    }
}
