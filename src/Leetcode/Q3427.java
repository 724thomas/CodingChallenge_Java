package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3427 {
    class Solution {
        public int subarraySum(int[] nums) {
            int n = nums.length, ans = 0;
            for (int i=0; i<n; i++) {
                int total = 0 ;
                for (int j=Math.max(0, i - nums[i]); j<=i; j++) total += nums[j];
                ans += total;
            }
            return ans;
        }
    }
}
