package Leetcode;

import java.util.Arrays;

public class Q280 {
    class Solution {
        public void swap(int[] nums, int idx1, int idx2){
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }

        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            for (int i=1; i<nums.length-1; i+=2){
                swap(nums, i, i+1);
            }
        }
    }
}
