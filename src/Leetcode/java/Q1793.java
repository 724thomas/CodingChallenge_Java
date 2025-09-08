package Leetcode.java;

/*
1. 아이디어 :
- 1번만에 돌아야함
- 투포인터와 그리디 접근
- k에서 시작해서 왼쪽 또는 오른쪽으로 이동

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / 그리디, 투포인터
 */

public class Q1793 {
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int n = nums.length;
            int i = k, j = k;
            int cmin = nums[k];
            int ans = nums[k];

            while (i > 0 || j < n-1) {
                if (i==0) {
                    j++;
                    cmin = Math.min(cmin, nums[j]);
                } else if (j == n-1) {
                    i--;
                    cmin = Math.min(cmin, nums[i]);
                } else {
                    if (nums[i-1] > nums[j+1]) {
                        i--;
                        cmin = Math.min(cmin, nums[i]);
                    } else {
                        j++;
                        cmin = Math.min(cmin, nums[j]);
                    }
                }
                ans = Math.max(ans, cmin * (j-i+1));
            }
            return ans;
        }
    }
}
