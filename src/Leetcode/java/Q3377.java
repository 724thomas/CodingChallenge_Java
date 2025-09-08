package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3377 {

    class Solution {
        int length;
        boolean[] isPrime;

        public boolean[] getPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            return isPrime;
        }

        public int bfs(int start, int target) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
            int[] minCost = new int[10000];
            Arrays.fill(minCost, Integer.MAX_VALUE);

            pq.add(new int[]{start, start});
            minCost[start] = start;

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int value = curr[0];
                int cost = curr[1];

                if (value == target) return cost;
                if (cost > minCost[value]) continue; // 이미 더 적은 비용으로 방문한 적 있음

                String str = String.valueOf(value);
                for (int i = 0; i < length; i++) {
                    char[] chars = str.toCharArray();
                    char orig = chars[i];

                    // 증가
                    if (orig < '9') {
                        chars[i] = (char)(orig + 1);
                        int next = Integer.parseInt(new String(chars));
                        if (!isPrime[next] && String.valueOf(next).length() == length) {
                            int nextCost = cost + next;
                            if (nextCost < minCost[next]) {
                                minCost[next] = nextCost;
                                pq.add(new int[]{next, nextCost});
                            }
                        }
                    }

                    // 감소
                    if (orig > '0') {
                        chars[i] = (char)(orig - 1);
                        int next = Integer.parseInt(new String(chars));
                        if (!isPrime[next] && String.valueOf(next).length() == length) {
                            int nextCost = cost + next;
                            if (nextCost < minCost[next]) {
                                minCost[next] = nextCost;
                                pq.add(new int[]{next, nextCost});
                            }
                        }
                    }
                }
            }

            return -1;
        }

        public int minOperations(int n, int m) {
            length = String.valueOf(n).length();
            isPrime = getPrimes(10000);
            if (isPrime[n] || isPrime[m]) return -1;
            return bfs(n, m);
        }
    }

}
