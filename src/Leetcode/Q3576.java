package Leetcode;

/*
1. 아이디어 :
1로 바꾸는 경우와 -1로 바꾸는 경우를 따로 계산
추가적인 배열을 만들지 않고 nums 배열을 직접 수정하여 계산

2. 시간복잡도 :
O( 3n )

3. 자료구조/알고리즘 :
- / dp
 */

public class Q3576 {
    class Solution {
        public boolean canMakeEqual(int[] nums, int k) {
            int n = nums.length;
            int count;
            int[] arr = new int[n];

            // 1로 바꾸기
            count = 0;
            for (int i=0; i<n-1; i++) {
                if (nums[i] < 0) {
                    nums[i+1] *= -2;
                    count++;
                }
            }
            if (count <= k && nums[n-1] > 0) return true;

            for (int i=0; i<n; i++) {
                if (Math.abs(nums[i]) % 2 == 0) nums[i] *= -0.5;
            }

            // -1로 바꾸기
            count = 0;
            for (int i=0; i<n-1; i++) {
                if (nums[i] > 0) {
                    nums[i+1] *= -2;
                    count++;
                }
            }
            if (count <= k && nums[n-1] < 0) return true;

            return false;


        }
    }
}
