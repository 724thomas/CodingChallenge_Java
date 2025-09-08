package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2047 {
    class Solution {
        public boolean check1(String s) {
            int n = s.length();
            if (n==0) return false;
            int hyphen = 0, punc = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) return false;
                if (c == '-') {
                    if (i == 0 || i == n-1
                            || !Character.isAlphabetic(s.charAt(i-1))
                            || !Character.isAlphabetic(s.charAt(i+1))) return false;
                    hyphen++;
                }
                if (c== '!' || c=='.' || c==',') {
                    if (i!= n-1) return false;
                    punc++;
                }
            }
            return (hyphen <= 1 && punc <= 1) ? true : false;
        }
        public int countValidWords(String sentence) {
            int ans = 0;
            int left = 0;
            boolean open = false;
            for (int right = 0; right<sentence.length(); right++) {
                if (sentence.charAt(right) == ' ' && open == true) {
                    open = false;
                    if (check1(sentence.substring(left, right))) ans++;
                    left = -1;
                } else if (sentence.charAt(right) != ' ' && open == false) {
                    open = true;
                    left = right;
                }
            }

            if (left != -1 && check1(sentence.substring(left))) ans++;
            return ans;
        }
    }
}
