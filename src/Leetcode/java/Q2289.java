package Leetcode.java;

import java.util.LinkedList;

public class Q2289 {
    public int totalSteps(int[] nums) {
        LinkedList<int[]> stack = new LinkedList<>();
        int max = 0;
        for(int num : nums) {
            int score = 0;
            while(stack.size() > 0 && stack.getLast()[0] <= num) {
                score = Math.max(score, stack.removeLast()[1]);
            }
            if (stack.size()==0){
                stack.add(new int[]{num, 0});
            } else {
                stack.add(new int[]{num, score+1});
            }
            max = Math.max(max, stack.getLast()[1]);
        }
        return max;
    }
}
