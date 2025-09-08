package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2107 {
    class Solution {
        public int shareCandies(int[] candies, int k) {
            int n = candies.length;
            int[] counter = new int[100001];
            int kinds = 0;
            for (int i=0; i<n; i++) {
                counter[candies[i]]++;
                if (counter[candies[i]]==1) kinds++;
            }

            int ans = 0;

            for (int i=0; i<k; i++) {
                counter[candies[i]]--;
                if (counter[candies[i]]==0) kinds--;
            }
            ans = Math.max(ans, kinds);

            for (int i=k; i<n; i++) {
                counter[candies[i]]--;
                if (counter[candies[i]]==0) kinds--;
                counter[candies[i-k]]++;
                if (counter[candies[i-k]]==1) kinds++;
                ans = Math.max(ans, kinds);
            }

            return ans;
        }
    }
}
