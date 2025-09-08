package Leetcode.java;

/*
1. 아이디어 :
1의 갯수를 카운트.
갯수-1개만큼 1을 넣고, 0을 채운뒤, 마지막에 1을 넣는다.

2. 시간복잡도 :
O( n + n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q2864 {
    class Solution {
        public String maximumOddBinaryNumber(String s) {
            int n = s.length();
            int ones = 0;
            for (char c : s.toCharArray()) {
                if (c=='1') ones++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n-1; i++) {
                if (ones > 1) {
                    sb.append('1');
                    ones--;
                } else {
                    sb.append('0');
                }
            }
            sb.append('1');
            return sb.toString();

        }
    }
}
