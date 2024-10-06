package Leetcode;

import java.util.Stack;

public class Q456 {

    class Solution {
        public boolean find132pattern(int[] nums) {
            if (nums == null || nums.length < 3) return false;

            reverse(nums);

            Stack<Integer> stack = new Stack<>();
            int second = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < second) {
                    return true; // 132 (231) 패턴을 찾음
                }
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = stack.pop(); // 스택에서 pop된 값이 두 번째 값에 해당
                }
                stack.push(nums[i]);
            }
            return false;
        }

        private void reverse(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

}
