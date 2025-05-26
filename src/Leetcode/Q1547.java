package Leetcode;

/*
1. 아이디어 :
dfs와 memoization을 사용하여 최소 비용을 계산합니다.

각 구간의 시작과 끝을 기준으로 자른 위치를 순회하면서, 해당 위치에서 자르는 비용을 계산하고 최소 비용을 갱신합니다.

2. 시간복잡도 :
O(m*m)

3. 자료구조/알고리즘 :
메모이제이션 / dfs
 */

import java.util.HashMap;
import java.util.Map;

public class Q1547 {
    class Solution {
        Map<String, Integer> memo = new HashMap<>();
        int[] cuts;

        public int dfs(int start, int end) {
            String key = start+","+end;
            if (memo.containsKey(key)) return memo.get(key);

            int minCost = Integer.MAX_VALUE;
            for (int cut : cuts) {
                if (start >= cut || cut >= end) continue;

                int cost = (end - start) + dfs(start, cut) + dfs(cut, end);
                minCost = Math.min(minCost, cost);
            }
            if (minCost == Integer.MAX_VALUE) minCost = 0;
            memo.put(key, minCost);
            return minCost;
        }

        public int minCost(int n, int[] cuts) {
            this.cuts = cuts;
            return dfs(0, n);
        }
    }
}
