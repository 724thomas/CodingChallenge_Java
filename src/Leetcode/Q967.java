package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q967 {
    class Solution {
        int n, k;
        Set<Integer> candids = new HashSet<>();
        public void backtrack(int lastDigit, int curr) {
            if (String.valueOf(curr).length() >= n) {
                candids.add(curr);
                return;
            }

            for (int i=0; i<10; i++) {
                if (Math.abs(lastDigit - i) == k) {
                    backtrack(i, curr * 10 + i);
                }
            }
        }
        public int[] numsSameConsecDiff(int n, int k) {
            this.n = n;
            this.k = k;

            for (int i=1; i<10; i++) backtrack(i, i);
            System.out.println(candids);
            int[] ans = new int[candids.size()];
            int idx = 0;
            for (int num : candids) ans[idx++] = num;
            return ans;
        }
    }
}
