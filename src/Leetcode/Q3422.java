package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q3422 {
    class Pair {
        int val, idx;
        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    class Solution {
        // lower: 최대힙(root=가장 큰 값),   upper: 최소힙(root=가장 작은 값)
        TreeSet<Pair> lower = new TreeSet<>((a, b) -> {
            if (a.val != b.val) return Integer.compare(b.val, a.val);
            return Integer.compare(a.idx, b.idx);
        });
        TreeSet<Pair> upper = new TreeSet<>((a,b) -> {
            if (a.val != b.val) return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });

        // 각 힙에 담긴 값들의 합을 유지
        long sumLower = 0, sumUpper = 0;
        Map<Integer, Pair> pairMap = new HashMap<>();

        public long minOperations(int[] nums, int k) {
            int n = nums.length;
            long ans = Long.MAX_VALUE;

            // 1) 초기 윈도우 채우기
            for (int i = 0; i < k; i++) {
                Pair p = new Pair(nums[i], i);
                addPair(p);
                pairMap.put(i, p);
            }
            ans = Math.min(ans, windowCost());

            // 2) 슬라이딩
            for (int i = k; i < n; i++) {
                // 왼쪽 제거
                Pair toRemove = pairMap.get(i - k);
                removePair(toRemove);
                // 오른쪽 추가
                Pair toAdd = new Pair(nums[i], i);
                addPair(toAdd);
                pairMap.put(i, toAdd);
                // 비용 계산
                ans = Math.min(ans, windowCost());
            }

            return ans;
        }

        // 윈도우의 median = lower.first().val
        private long windowCost() {
            long m = lower.first().val;
            return m * lower.size() - sumLower + sumUpper - m * upper.size();
        }

        private void addPair(Pair p) {
            // lower 비어있거나 p ≤ lower.max 이면 lower에, 아니면 upper에
            if (lower.isEmpty() || p.val <= lower.first().val) {
                lower.add(p);
                sumLower += p.val;
            } else {
                upper.add(p);
                sumUpper += p.val;
            }
            balanceHeaps();
        }

        private void removePair(Pair p) {
            // 어느 힙에 있든 제거하고, 합에서 빼주기
            if (lower.remove(p)) {
                sumLower -= p.val;
            } else {
                upper.remove(p);
                sumUpper -= p.val;
            }
            balanceHeaps();
        }

        private void balanceHeaps() {
            // lower.size >= upper.size, 두 크기의 차 ≤ 1
            if (lower.size() > upper.size() + 1) {
                Pair moved = lower.pollFirst();
                sumLower -= moved.val;
                upper.add(moved);
                sumUpper += moved.val;
            } else if (lower.size() < upper.size()) {
                Pair moved = upper.pollFirst();
                sumUpper -= moved.val;
                lower.add(moved);
                sumLower += moved.val;
            }
        }
    }

}
