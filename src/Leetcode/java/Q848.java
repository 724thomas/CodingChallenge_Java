package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q848 {
    class Solution {
        public Character shifted(Character c, int count) {
            return (char)((c - 'a' + count) % 26 + 'a');
        }

        public String shiftingLetters(String s, int[] shifts) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            sb.append(shifted(s.charAt(n-1), shifts[n-1]));
            for (int i = n-2; i>-1; i--) {
                shifts[i] = (shifts[i] + shifts[i+1]) % 26;
                sb.append(shifted(s.charAt(i), shifts[i]));
            }

            return sb.reverse().toString();
        }
    }
}
