package Leetcode;

/*
1. 아이디어 :
누적 최대값과 누적 최소값을 사용

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
2차원 배열 / 누적 최대값, 누적 최소값
 */

public class Q2012 {
    class Solution {
        public int sumOfBeauties(int[] nums) {
            int n = nums.length;
            int[][] prefix = new int[n][2];
            prefix[0][0] = nums[0];
            prefix[n-1][1] = nums[n-1];

            for (int i=1; i<n; i++) {
                prefix[i][0] = Math.max(prefix[i-1][0], nums[i]);
                prefix[n-1-i][1] = Math.min(prefix[n-i][1], nums[n-i-1]);
            }

            int ans = 0;
            for (int i=1; i<n-1; i++) {
                if (prefix[i-1][0] < nums[i] && nums[i] < prefix[i+1][1]) {
                    ans += 2;
                } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                    ans++;
                }
            }

            return ans;
        }
    }
}
