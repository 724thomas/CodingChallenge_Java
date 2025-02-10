package Leetcode;

/*
1. 아이디어 :
s의 i, t의 j 포인터를 사용합니다
- s[i] == t[j] 이면 해당 char을 찾았기때문에 i, j를 옮겨줍니다.
- s[i] != t[j] 이면 해당 char을 못찾았기때문에 j를 옮겨줍니다.

2. 시간복잡도 :
O( t )

3. 자료구조/알고리즘 :
문자열 / 투포인터
 */

public class Q392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int i =0, j=0;

            while (i<s.length() && j<t.length()) {
                if (s.charAt(i) == t.charAt(j)) i++;
                j++;
            }

            return i == s.length();
        }
    }
}
