package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Q3349 {
    class Solution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int n = nums.size();
            boolean[] increasingIdx = new boolean[n];
            Deque<int[]> deque = new ArrayDeque<>();

            for (int i=0; i<n; i++) {
                int num = nums.get(i);
                if (!deque.isEmpty() && deque.peekLast()[0] >= num) {
                    deque = new ArrayDeque<>();
                    deque.add(new int[]{num, i});
                } else {
                    deque.add(new int[]{num, i});
                    if (deque.size() == k) {
                        int idx = deque.pollFirst()[1];
                        increasingIdx[idx] = true;
                        if (idx>=k && increasingIdx[idx-k]) return true;
                    }
                }
            }
            return false;
        }
    }
}
