package Leetcode;

public class Q1961 {
    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word);
                if (s.equals(sb.toString())) return true;
            }
            return false;
        }
    }
}
