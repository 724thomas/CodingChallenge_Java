package Leetcode.java;

public class Q2955 {
    class Solution {

        public int calculateSameEnds(int[][] prefixCount, int start, int end) {
            int[] count = new int[26];

            for (int i = 0; i < 26; i++) {
                count[i] = prefixCount[end][i];
                if (start > 0) {
                    count[i] -= prefixCount[start - 1][i];
                }
            }

            int ans = end - start + 1;
            for (int value : count) {
                if (value > 0) {
                    ans += ((1 + value - 1) * (value - 1)) / 2;
                }
            }
            return ans;
        }

        public int[] sameEndSubstringCount(String s, int[][] queries) {
            int n = s.length();
            int[][] prefixCount = new int[n][26];
            prefixCount[0][s.charAt(0) - 'a']++;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    prefixCount[i][j] = prefixCount[i - 1][j];
                }
                prefixCount[i][s.charAt(i) - 'a']++;
            }

            int m = queries.length;
            int[] ans = new int[m];

            for (int i = 0; i < m; i++) ans[i] = calculateSameEnds(prefixCount, queries[i][0], queries[i][1]);
            return ans;
        }


    }

}
