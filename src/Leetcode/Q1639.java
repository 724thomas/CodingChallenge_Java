package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1639 {
    class Solution {
        List<int[]> charsAtIdx = new ArrayList<>();
        int MOD = 1_000_000_007;
        long[][] dp;

        public long dfs(int idx, int k, String target) {
            if (idx == target.length()) return 1;
            if (k == charsAtIdx.size()) return 0;
            if (dp[idx][k] != -1) return dp[idx][k];

            dp[idx][k] = dfs(idx, k+1, target); // skip

            char c = target.charAt(idx);
            dp[idx][k] += dfs(idx+1, k+1, target) * charsAtIdx.get(k)[c-'a'];
            return dp[idx][k] % MOD;
        }

        public int numWays(String[] words, String target) {
            int wordLength = words[0].length();
            dp = new long[target.length()][wordLength];
            for (long[] d : dp) Arrays.fill(d, -1);

            for (int i=0; i<wordLength; i++) {
                int[] counter = new int[26];
                for (String word : words) {
                    counter[word.charAt(i)-'a']++;
                }
                charsAtIdx.add(counter);
            }

            return (int) dfs(0,0,target);

        }
    }
}
