package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1576 {
    class Solution {
        public Character getChar(char left, char right) {
            System.out.println(left + " " + right);
            for (int i=0; i<26; i++) {
                char mid = (char)(i+'a');
                if (mid != left && mid != right) return mid;
            }
            return 'a';
        }

        public String modifyString(String s) {
            int n = s.length();
            char[] chars = new char[n];
            for (int i=0; i<n; i++) chars[i] = s.charAt(i);

            for (int i=0; i<n; i++) {
                if (chars[i] != '?') continue;
                char left = chars[(n + i-1)%n];
                char right = chars[(n+i+1)%n];
                chars[i] = getChar(left, right);
            }

            StringBuilder sb = new StringBuilder();
            for (char c : chars) sb.append(c);
            return sb.toString();
        }
    }
}
