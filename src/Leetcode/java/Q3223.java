package Leetcode.java;

public class Q3223 {
    class Solution {
        public int minimumLength(String s) {
            int[] counter = new int[26];
            for (char c:s.toCharArray()) {
                counter[c-'a']++;
            }

            int ans = 0;
            for (int i=0; i<26; i++) {
                int count = counter[i];
                while (count >= 3) count-=2;
                ans += count;
            }


            return ans;
        }
    }
}
