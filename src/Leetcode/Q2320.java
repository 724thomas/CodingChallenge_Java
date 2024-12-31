package Leetcode;

public class Q2320 {
    class Solution {
        public int countHousePlacements(int n) {
            int MOD = 1000000007;
            if (n == 1) return 2*2;

            int a = 2, b = 3;
            for (int i=0; i<n-2; i++) {
                int temp = a;
                a = b;
                b  = (b + temp) % MOD;
            }
            return (int)((1L * b*b) % MOD);
        }
    }
}
