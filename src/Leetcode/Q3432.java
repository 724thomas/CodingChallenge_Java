package Leetcode;

/*
1. 아이디어 :
총합을 통해 left와 right의 차이를 구합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / 누적합
 */

public class Q3432 {
    class Solution {
        public int countPartitions(int[] nums) {
            int n = nums.length;
            int right = 0;
            for (int num: nums) right += num;

            right -= nums[0];
            int left = nums[0];
            int ans = 0;
            for (int i=1; i<n-1; i++) {
                if (Math.abs(left - right) % 2 == 0) ans++;
                left += nums[i];
                right -= nums[i];
            }
            if (Math.abs(left - right) % 2 == 0) ans++;
            return ans;
        }
    }
}
