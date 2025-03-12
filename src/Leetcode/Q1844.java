package Leetcode;

/*
1. 아이디어 :
i가 홀수이면 c를 append
i가 짝수이면 s[i-1] + c를 append

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q1844 {
    class Solution {

        public String replaceDigits(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (i%2 ==0) {
                    sb.append(c);
                } else {
                    sb.append((char)(s.charAt(i-1)+Integer.parseInt(c+"")));
                }
            }
            return sb.toString();
        }
    }
}
