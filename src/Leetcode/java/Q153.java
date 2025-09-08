package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q153 {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            if (n == 1 || nums[0] < nums[n-1]) return nums[0];

            int left = 0, right = n-1;
            while (left <= right) {
                int mid = left + (right-left)/2;

                if (nums[mid] < nums[(n+mid-1)%n] && nums[mid] < nums[(n+mid+1)%n]) return nums[mid];
                if (nums[0] <= nums[mid]) {
                    left = mid+1;
                } else if (nums[0] > nums[mid]) {
                    right = mid-1;
                }

            }
            return -1;
        }
    }
}
