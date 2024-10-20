package Leetcode;

public class Q161 {
    class Solution {
        public boolean dfs(String s, String t, int sIdx, int tIdx, boolean changed) {
            if (sIdx == s.length() && tIdx == t.length()) return changed;
            if (sIdx == s.length()) return !changed && tIdx + 1 == t.length();
            if (tIdx == t.length()) return !changed && sIdx + 1 == s.length();

            if (s.charAt(sIdx) == t.charAt(tIdx)) return dfs(s, t, sIdx + 1, tIdx + 1, changed);

            if (changed) return false;
            boolean replace = dfs(s, t, sIdx + 1, tIdx + 1, true);
            boolean insert = dfs(s, t, sIdx, tIdx + 1, true);
            boolean delete = dfs(s, t, sIdx + 1, tIdx, true);

            return replace || insert || delete;
        }

        public boolean isOneEditDistance(String s, String t) {
            return dfs(s, t, 0, 0, false);
        }
    }

}
