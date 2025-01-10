package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q2707 {
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();
            int[] dp = new int[n+1]; // leftovers
            Set<String> dic = new HashSet<>();
            for (String word : dictionary) dic.add(word);

            for (int i=1; i<n+1; i++) {
                dp[i] = dp[i-1] + 1;

                for (int j = 0; j<i; j++) {
                    if (dic.contains(s.substring(j, i))) dp[i] = Math.min(dp[i], dp[j]);
                }
            }

            // System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
