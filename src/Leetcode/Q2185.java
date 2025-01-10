package Leetcode;

public class Q2185 {
    class Solution {
        public int check(String word, String pref) {
            if (pref.length() > word.length()) return 0;
            for (int i=0; i<pref.length(); i++) {
                if (word.charAt(i) != pref.charAt(i)) return 0;
            }
            return 1;
        }
        public int prefixCount(String[] words, String pref) {
            int ans = 0;
            for (String word : words) ans += check(word, pref);
            return ans;
        }
    }
}
