package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2475 {
    class Solution {
        public int unequalTriplets(int[] nums) {
            int n = nums.length, ans = 0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) for (int k=j+1; k<n; k++) {
                if (nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
