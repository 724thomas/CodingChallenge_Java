package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3726 {
    class Solution {
        public long removeZeros(long n) {
            StringBuilder sb = new StringBuilder();
            String sn = String.valueOf(n);
            for (char c : sn.toCharArray()) {
                if (c == '0') continue;
                sb.append(c);
            }
            return Long.parseLong(sb.toString());
        }
    }
}
