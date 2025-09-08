package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q397 {
    class Solution {
        int ans = Integer.MAX_VALUE;
        public void dfs(long n, int count) {
            if (n==1) {
                ans = Math.min(ans, count);
                return;
            }

            if (n%2==0) {
                dfs(n/2, count+1);
            } else {
                dfs(n+1, count+1);
                dfs(n-1, count+1);
            }
        }
        public int integerReplacement(int n) {
            dfs((long)n, 0);
            return ans;
        }
    }
}
