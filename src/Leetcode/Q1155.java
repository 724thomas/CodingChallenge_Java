package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1155 {
    class Solution {
        int n, k, target;
        int MOD = 1000000007;
        Integer[][] cache;

        public int dfs(int diceIdx, int amount) {
            if (diceIdx == n) {
                return (amount == 0)? 1 : 0;
            }
            if (amount <=0) return 0;

            if (cache[diceIdx][amount] != null) {
                return cache[diceIdx][amount];
            }

            int total = 0;
            for (int i=1; i<=k; i++) {
                total = (total + dfs(diceIdx+1, amount-i)) % MOD;
            }

            cache[diceIdx][amount] = total;
            return total;
        }

        public int numRollsToTarget(int n, int k, int target) {
            this.n = n;
            this.k = k;
            this.target = target;
            cache = new Integer[30+2][1000+2];

            return dfs(0, target);
        }
    }
}
