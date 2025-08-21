package Leetcode;

/*
1. 아이디어 :
두 문자열이 같으면 -1을 반환하고, 다르면 두 문자열의 길이 중 큰 값을 반환

2. 시간복잡도 :
O( 1 )

3. 자료구조/알고리즘 :
- / -
 */

public class Q521 {
    class Solution {
        public int findLUSlength(String a, String b) {
            if (a.equals(b)) return -1;
            return Math.max(a.length(), b.length());
        }
    }
}
