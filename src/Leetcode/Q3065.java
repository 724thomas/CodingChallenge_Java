package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3065 {
    class Solution {
        public int minOperations(int[] nums, int k) {
            int ans = 0;
            for (int num : nums) if (num < k) ans++;
            return ans;
        }
    }
}
