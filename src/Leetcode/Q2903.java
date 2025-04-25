package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2903 {
    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int n = nums.length;
            int[] ans = new int[]{-1,-1};
            for (int i=0; i<n; i++) for (int j=i; j<n; j++) {
                if (j-i < indexDifference || Math.abs(nums[i] - nums[j]) < valueDifference) continue;
                ans = new int[]{i, j};
                break;
            }
            return ans;
        }
    }
}
