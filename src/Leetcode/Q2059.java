package Leetcode;

/*
1. 아이디어 :
BFS를 통해 start에서 goal로 가는 최소 연산 횟수를 구합니다.

2. 시간복잡도 :
O( n * 3 * m ) n = nums.length, m = 1001 (0~1000)

3. 자료구조/알고리즘 :
- Deque / BFS
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q2059 {
    class Solution {
        public int minimumOperations(int[] nums, int start, int goal) {
            Deque<Integer> deque = new ArrayDeque<>(); // num, count
            deque.add(start);
            int[] counts = new int[1001];
            Arrays.fill(counts, -1);
            counts[start] = 0;

            while (!deque.isEmpty()) {
                int x = deque.pollFirst();
                int count = counts[x];

                for (int num : nums) {
                    int[] candids = new int[]{x + num, x - num, x ^ num};
                    for (int candid : candids) {
                        if (candid == goal) return count+1;
                        if (candid < 0 || candid > 1000 || counts[candid] != -1) continue;
                        counts[candid] = count+1;
                        deque.add(candid);
                    }
                }
            }
            return -1;
        }
    }
}
