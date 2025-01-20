package Leetcode;

public class Q3407 {
    class Solution {
        public boolean hasMatch(String s, String p) {
            if (p.equals("*")) return true;

            String[] ps = p.split("\\*");
            String prefix = ps[0], suffix = ps.length > 1 ? ps[1] : "";
            int left = s.indexOf(prefix), right = s.lastIndexOf(suffix);

            if (left == -1 || right == -1) return false;

            return left + prefix.length() <= right;
        }
    }
}
