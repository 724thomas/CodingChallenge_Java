package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3038 {
    class Solution {
        public int maxOperations(int[] nums) {
            int n = nums.length, idx = 2, ans = 1;
            while (idx<n-1 && nums[idx-2] + nums[idx-1] == nums[idx] + nums[idx+1]) {
                idx+=2;
                ans++;
            }
            return ans;
        }
    }
}
