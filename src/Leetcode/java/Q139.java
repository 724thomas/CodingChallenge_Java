package Leetcode.java;

import java.util.List;

public class Q139 {
    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakRecur(s, wordDict, 0, new boolean[s.length()]);
        }

        private boolean wordBreakRecur(String s, List<String> wordDict, int start, boolean[] memo) {
            if (start == s.length()) return true;
            if (memo[start]) return false;

            for (String word : wordDict) {
                if (s.startsWith(word, start) &&
                        wordBreakRecur(s, wordDict, start + word.length(), memo))
                    return true;
            }
            memo[start] = true;
            return false;
        }
    }
}
