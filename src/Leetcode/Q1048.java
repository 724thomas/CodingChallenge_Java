package Leetcode;

/*
1. 아이디어 :
Bottom-Up DP를 사용하여, 각 단어에 대해 가장 긴 단어 체인의 길이를 계산합니다.
isPredecessor 메서드를 통해 단어 A가 단어 B의 바로 앞 단어인지 확인합니다.

2. 시간복잡도 :
O( n^2 * m )

3. 자료구조/알고리즘 :
배열 / DP
 */

import java.util.Arrays;

public class Q1048 {
    class Solution {
        public boolean isPredecessor(String wordA, String wordB) {
            if (wordA.length()+1 != wordB.length()) return false;
            int n = wordA.length();
            int left = 0, right = 0;
            boolean diff = false;

            while (left<n && right<n+1) {
                if (wordA.charAt(left) != wordB.charAt(right)) {
                    if (diff) return false;
                    diff = true;
                    right++;
                } else {
                    left++;
                    right++;
                }
            }
            return true;
        }

        public int longestStrChain(String[] words) {
            int n = words.length;
            Arrays.sort(words, (a, b)->b.length() - a.length());

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int ans = 1;

            for (int i=n-1; i>-1; i--) {
                for (int j=i+1; j<n; j++) {
                    if (!isPredecessor(words[j], words[i])) continue;
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                ans = Math.max(ans, dp[i]);
            }

            return ans;
        }
    }
}
