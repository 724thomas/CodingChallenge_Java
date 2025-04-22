package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2244 {
    class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> counter = new HashMap<>();
            int cmax = 0;
            for (int t : tasks) {
                counter.put(t, counter.getOrDefault(t, 0)+1);
                cmax = Math.max(cmax, counter.get(t));
            }

            int[] dp = new int[cmax+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i=1; i<cmax+1; i++) {
                if (i >= 2 && dp[i-2] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-2] + 1);
                if (i >= 3 && dp[i-3] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-3] + 1);
            }

            int ans = 0;
            for (int count : counter.values()) {
                if (dp[count] == Integer.MAX_VALUE) return -1;
                ans+=dp[count];
            }
            return ans;
        }
    }
}
