package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1601 {
    class Solution {
        List<List<Integer>> candids = new ArrayList<>();
        int[][] requests;

        public void backtrack(List<Integer> curr, int n, int idx, Map<Integer, Integer> counter) {
            if (idx >= n) {
                int total = 0;
                for (var entry : counter.values()) {
                    total += Math.abs(entry);
                }
                if (total == 0) {
                    candids.add(new ArrayList<>(curr));
                }
                return;
            }

            curr.add(idx);
            int from = requests[idx][0], to = requests[idx][1];
            counter.put(from, counter.getOrDefault(from, 0) + 1);
            counter.put(to, counter.getOrDefault(to, 0) - 1);
            backtrack(curr, n, idx + 1, counter);

            curr.remove(curr.size() - 1);
            counter.put(from, counter.get(from) - 1);
            counter.put(to, counter.get(to) + 1);

            backtrack(curr, n, idx + 1, counter);
        }

        public int maximumRequests(int n, int[][] requests) {
            this.requests = requests;
            backtrack(new ArrayList<>(), requests.length, 0, new HashMap<>());

            int max = 0;
            for (List<Integer> candid : candids) {
                max = Math.max(max, candid.size());
            }
            return max;
        }
    }

}
