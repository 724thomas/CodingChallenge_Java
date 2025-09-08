package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3298 {


    class Solution {
        public long validSubstringCount(String word1, String word2) {
            int n = word1.length(), m = word2.length();
            int[] count1 = new int[26], count2 = new int[26];

            for (int i = 0; i < m; i++) count2[word2.charAt(i) - 'a']++;

            long ans = 0;
            int right = 0;

            for (int left = 0; left < n; left++) {
                while (right < n && !check(count1, count2)) {
                    count1[word1.charAt(right) - 'a']++;
                    right++;
                }

                if (check(count1, count2)) {
                    ans += n - right + 1;
                }

                count1[word1.charAt(left) - 'a']--;
            }

            return ans;
        }

        private boolean check(int[] count1, int[] count2) {
            for (int i = 0; i < 26; i++) {
                if (count1[i] < count2[i]) return false;
            }
            return true;
        }
    }

}
