package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1160 {
    class Solution {
        public int[] getCounter(String s) {
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c-'a']++;
            }
            return counter;
        }

        public boolean check(int[] base, int[] target) {
            for (int i=0; i<26; i++) {
                if (base[i] < target[i]) return false;
            }
            return true;
        }
        public int countCharacters(String[] words, String chars) {
            int[] base = getCounter(chars);
            int ans = 0;
            for (String word : words) {
                if (check(base, getCounter(word))) {
                    ans += word.length();
                }
            }
            return ans;
        }
    }
}
