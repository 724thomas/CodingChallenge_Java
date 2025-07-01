package Leetcode;

/*
1. 아이디어 :
quantity는 10개 이하, nums의 종류는 50개 이하.
이떄 nums의 값은 중요하지 않고, 각 값의 개수만 중요.
각 값의 개수를 counts에 저장.
quantity를 내림차순으로 정렬하여, 빠르게 실패 하는 경우를 줄임.

백트래킹을 통해서, 각 quantity마다 counts에서 값을 빼가며 조합을 찾습니다.

2. 시간복잡도 :
O( n + mlogm + 50^m )

3. 자료구조/알고리즘 :
리스트, 맵 / 백트래킹
 */

import java.util.*;

public class Q1655 {
    class Solution {
        List<Integer> counts = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        int[] nums, quantity;
        int n, m;
        boolean ans = false;

        public void backtrack(int idx) {
            if (ans) return;
            if (idx == m) {
                ans = true;
                return;
            }

            int q = quantity[idx];
            for (int i=0; i<counts.size(); i++) {
                int val = counts.get(i);
                if (val < q) continue;

                counts.set(i, val-q);
                backtrack(idx+1);
                counts.set(i, val);
            }
        }

        public boolean canDistribute(int[] nums, int[] quantity) {
            this.nums = nums;
            this.quantity = quantity;
            n = nums.length;
            m = quantity.length;

            for (int num : nums) counter.put(num, counter.getOrDefault(num, 0)+1);
            counts.addAll(counter.values());
            Arrays.sort(quantity);
            reverse(quantity);

            backtrack(0);

            return ans;
        }

        public void reverse(int[] arr) {
            int l = 0, r = arr.length-1;
            while (l<r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
}
