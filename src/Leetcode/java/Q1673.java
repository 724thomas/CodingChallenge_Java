package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Stack;

public class Q1673 {
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            int[] ans = new int[k];
            for (int i = 0; i < n; i++) {
                int curr = nums[i];
                while (!stack.empty() && curr < stack.peek() && nums.length - i + stack.size() > k) {
                    stack.pop();
                }
                if (stack.size() < k) {
                    stack.push(curr);
                }
            }
            for (int i = k - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
