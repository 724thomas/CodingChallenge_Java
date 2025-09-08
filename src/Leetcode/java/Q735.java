package Leetcode.java;

import java.util.Stack;

public class Q735 {
    class Solution {
        Stack<Integer> stack;
        boolean collision;
        public int[] asteroidCollision(int[] asteroids) {
            stack = new Stack<>();
            for (Integer curr : asteroids){
                collision = false;
                while (!stack.isEmpty() && stack.peek() > 0 && curr < 0){
                    int prev = stack.peek();

                    if (Math.abs(prev) > Math.abs(curr)){
                        collision = true;
                        break;
                    } else if (Math.abs(prev) < Math.abs(curr)) {
                        stack.pop();
                    } else {
                        stack.pop();
                        collision = true;
                        break;
                    }
                }
                if (!collision) stack.add(curr);
            }
            int[] ans = new int[stack.size()];
            for (int i=0; i<stack.size(); i++){
                ans[i] = stack.get(i);
            }
            return ans;
        }
    }
}
