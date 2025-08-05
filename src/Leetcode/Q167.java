package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q167 {
    class Solution {
        int[] nums;
        int target;

        public int binarySearch(int left, int right, int target) {

            while (left<=right) {
                int mid = left + (right-left)/2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            nums = numbers;
            this.target=target;

            for (int i=0; i<n; i++) {
                int num = numbers[i];
                int bs = binarySearch(i+1, n-1, target - num);
                if (bs != -1) return new int[]{i+1, bs+1};
            }
            return null;
        }
    }
}
