package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q3556 {

    class Solution {
        public long sumOfLargestPrimes(String s) {
            Set<Long> candids = new HashSet<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                long curr = 0;
                for (int j = i; j < n; j++) {
                    int digit = s.charAt(j) - '0';
                    curr = curr * 10 + digit;
                    candids.add(curr);
                }
            }

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (long candid : candids) {
                if (!isPrime(candid))
                    continue;
                pq.add(candid);
                if (pq.size() > 3)
                    pq.poll();
            }

            long ans = 0;
            while (!pq.isEmpty())
                ans += pq.poll();
            return ans;
        }

        public boolean isPrime(long num) {
            if (num < 2)
                return false;
            if (num > 5 && (num % 2 == 0 || num % 3 == 0 || num % 5 == 0))
                return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }
    }

}
