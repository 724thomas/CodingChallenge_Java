package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2450 {
    class Solution {
        public int countDistinctStrings(String s, int k) {
            int ans = 1;
            int MOD = 1000000007;
            for (int i=0; i<s.length()-k+1; i++) {
                ans = (ans*2) % MOD;
            }
            return ans;
        }
    }
}
