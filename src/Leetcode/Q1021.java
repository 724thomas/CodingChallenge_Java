package Leetcode;

/*
1. 아이디어 :
counter를 이용하여 '('의 개수를 세고, '('가 0이 아닐 때만 StringBuilder에 추가한다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q1021 {
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    if (counter != 0) sb.append(c);
                    counter++;
                } else {
                    counter--;
                    if (counter != 0) sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
