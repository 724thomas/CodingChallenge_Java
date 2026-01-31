package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3683 {
    class Solution {
        public int earliestTime(int[][] tasks) {
            int ans = Integer.MAX_VALUE;
            for (int[] task : tasks) {
                ans = Math.min(ans, task[0] + task[1]);
            }
            return ans;
        }
    }
}
