package Leetcode;

/*
1. 아이디어 :
nums[i-1] >= nums[i]인 경우, i-1번째 또는 i번째 원소를 제거하고 나머지 원소가 증가하는지 확인한다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

public class Q1909 {
    class Solution {
        int[] nums;
        int n;
        public boolean canBeIncreasing(int[] nums) {
            n = nums.length;
            this.nums = nums;
            for (int i=1; i<n; i++) {
                if (nums[i-1] >= nums[i]) {
                    return check(i-1) || check(i);
                }
            }
            return true;
        }

        public boolean check(int removeIdx) {
            int prev = -1;
            for (int i=0; i<nums.length; i++) {
                if (i == removeIdx) continue;
                if (prev >= nums[i]) return false;
                prev = nums[i];
            }
            return true;
        }
    }
}
