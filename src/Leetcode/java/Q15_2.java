package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q15_2 {
    class Solution {
        int[] nums;
        public int binarySearch(int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return -1;
        }
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            this.nums = nums;

            Set<List<Integer>> ans = new HashSet<>();
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                int remain = nums[i] + nums[j];
                int bs = binarySearch(j+1, n-1, -remain);
                if (bs == -1) continue;
                List<Integer> candid = new ArrayList<>();
                candid.add(nums[i]);
                candid.add(nums[j]);
                candid.add(nums[bs]);
                Collections.sort(candid);
                ans.add(candid);
            }
            return new ArrayList<>(ans);
        }
    }
}
