package Leetcode;

/*
1. 아이디어 :
3중 포문으로 3개의 수를 더한 값을 구하고, 네번째 포문으로 비교합니다.

2. 시간복잡도 :
O( n**4 )

3. 자료구조/알고리즘 :

 */

public class Q1995 {
    class Solution {
        public int countQuadruplets(int[] nums) {
            int n=nums.length;
            int ans = 0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) for (int k=j+1; k<n; k++) {
                int total = nums[i] + nums[j] + nums[k];
                for (int z = k+1; z<n; z++) {
                    if (total == nums[z]) ans++;
                }
            }
            return ans;
        }
    }
}
