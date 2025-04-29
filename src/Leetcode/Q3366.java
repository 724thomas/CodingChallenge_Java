package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3366 {
    class Solution {
        List<Integer> nums = new ArrayList<>();
        int k, n;
        Integer[][][] dp;

        public int dfs(int idx, int op1, int op2) {
            if (idx == n) return 0;
            if (dp[idx][op1][op2] != null) return dp[idx][op1][op2];

            int num = nums.get(idx);
            int ans = num + dfs(idx+1, op1, op2);

            if (op1 > 0) {
                int val = (num+1)/2;
                ans = Math.min(ans, val + dfs(idx+1, op1-1, op2));
            }

            if (op2 > 0 && num >= k) {
                int val = num - k;
                ans = Math.min(ans, val + dfs(idx+1, op1, op2-1));
            }

            if (op1 > 0 && op2 > 0) {
                int val1 = (num+1)/2;
                if (val1 >= k) {
                    int val2 = val1 -k;
                    ans = Math.min(ans, val2 + dfs(idx+1, op1-1, op2-1));
                }
            }

            if (op1 > 0 && op2 > 0) {
                if (num >= k) {
                    int val1 = num -k;
                    int val2 = (val1+1)/2;
                    ans = Math.min(ans, val2 + dfs(idx+1, op1-1, op2-1));
                }
            }

            dp[idx][op1][op2] = ans;
            return ans;
        }

        public int minArraySum(int[] ns, int k, int op1, int op2) {
            for (int num : ns) nums.add(num);
            Collections.sort(nums, Collections.reverseOrder());
            System.out.println(nums);
            this.k = k;
            this.n = nums.size();
            dp = new Integer[n+1][op1+1][op2+1];

            return dfs(0, op1, op2);

        }
    }
}
