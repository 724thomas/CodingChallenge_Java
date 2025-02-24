package Leetcode;

/*
1. 아이디어 :
에라스토테네스의 체를 통해서 prime 갯수를 구합니다.
prime의 조합 방법 * non-prime의 조합방법

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / 에라스토테네스의 체
 */

import java.util.Arrays;

public class Q1175 {
    class Solution {
        int MOD = 1_000_000_007;
        public int erastos(int n) {
            boolean[] isPrime = new boolean[n+1];
            Arrays.fill(isPrime, true);
            if (n >= 0) isPrime[0] = false;
            if (n >= 1) isPrime[1] = false;

            for (int i=2; i*i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j<=n; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i=2; i<=n; i++) {
                if (isPrime[i]) count++;
            }
            return count;
        }
        public int numPrimeArrangements(int n) {
            int primes = erastos(n);
            long ans1 = 1L, ans2 = 1L;
            for (int i=1; i<=primes; i++) {
                ans1 = (ans1 * i) % MOD;
            }

            for (int i=1; i<= n-primes; i++) {
                ans2 = (ans2 * i) % MOD;
            }
            return (int)((ans1 * ans2) % MOD);
        }
    }
}
