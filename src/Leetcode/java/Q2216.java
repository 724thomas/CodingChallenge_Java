package Leetcode.java;

/*
1. 아이디어 :
deque 또는 어떠한 자료구조를 통해, 2개씩 끊어서 확인

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
Deque
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2216 {
    class Solution {
        public int minDeletion(int[] nums) {
            int n = nums.length;
            int deletes = 0;

            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(nums[0]);

            for (int i=1; i<n; i++) {
                if (deque.isEmpty()) {
                    deque.add(nums[i]);
                } else {
                    int lastNum = deque.pollLast();
                    if (nums[i] == lastNum) {
                        deletes++;
                        deque.add(lastNum);
                    }
                }
            }
            return (deque.isEmpty()) ? deletes : deletes+1;
        }
    }
}
