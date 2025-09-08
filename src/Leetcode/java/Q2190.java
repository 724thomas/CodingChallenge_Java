package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2190 {
    class Solution {
        public int mostFrequent(int[] nums, int key) {
            int[] counter = new int[1001];
            int ans = 0, cmax = 0;
            for (int i=0; i<nums.length-1; i++) {
                if (nums[i] != key) continue;

                int nextNum = nums[i+1];
                counter[nextNum]++;
                int count = counter[nextNum];

                if (count < cmax) continue;

                ans = nextNum;
                cmax = count;
            }

            return ans;
        }
    }
}
