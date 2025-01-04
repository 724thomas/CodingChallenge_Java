package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q2559 {
    class Solution {
        public int check(String word, Set<Character> vowels) {
            return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1)) ? 1: 0;
        }
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length, m = queries.length;
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            int[] prefixSum = new int[n];
            prefixSum[0] = check(words[0], vowels);
            for (int i=1; i<n; i++) prefixSum[i] = prefixSum[i-1] + check(words[i], vowels);

            int[] ans = new int[m];
            for (int i=0; i<m; i++) {
                int[] q = queries[i];
                int start = q[0]-1, end = q[1];
                ans[i] = start<0? prefixSum[end] : prefixSum[end]-prefixSum[start];
            }

            return ans;
        }
    }
}
