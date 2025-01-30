package Leetcode;

public class Q1400 {
    class Solution {
        public boolean canConstruct(String s, int k) {
            if (s.length() < k) return false;

            int odds = 0;
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                int key = c-'a';
                counter[key]++;
                odds += (counter[key] %2 == 1) ? 1 : -1;
            }

            return odds<=k;
        }
    }
}
