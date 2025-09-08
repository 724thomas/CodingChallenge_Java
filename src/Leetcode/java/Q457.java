package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q457 {
    class Solution {
        int n;
        int[] nums;
        public boolean circularArrayLoop(int[] nums) {
            n = nums.length;
            this.nums = nums;

            for (int i=0; i<n; i++) {
                System.out.println(isCycle(i));
                if (isCycle(i)) return true;
            }
            return false;
        }

        public int getNextIdx(int idx) {
            int curr = nums[idx];
            int nextIdx = ((idx + curr) % n + n) % n;
            return nextIdx;
        }

        public boolean isCycle(int idx) {
            if (nums[idx] == 0) return false;
            int direction = nums[idx] >= 1? 1 : -1;
            int slow = idx, fast = getNextIdx(idx);

            while (nums[fast] * direction > 0 && nums[getNextIdx(fast)] * direction > 0) { // same direction
                if (slow == fast) { // found cycle
                    return slow != getNextIdx(slow);
                }

                slow = getNextIdx(slow);
                fast = getNextIdx(getNextIdx(fast));
            }
            return false;
        }
    }
}
