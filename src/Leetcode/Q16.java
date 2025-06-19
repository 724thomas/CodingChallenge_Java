package Leetcode;

/*
1. 아이디어 :
정렬 후, 왼쪽 숫자는 순회를 하고, 중간 + 오른쪽 숫자는 투포인터로 합을 구한다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
- / 투포인터
 */

import java.util.Arrays;

public class Q16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int maxDiff = Integer.MAX_VALUE, ans = -1;
            Arrays.sort(nums);
            int n = nums.length;

            for (int left = 0; left < n; left ++) {
                int mid = left+1, right = n-1;

                while (mid < right) {
                    int total = nums[left] + nums[mid] + nums[right];
                    int cDiff = Math.abs(total - target);
                    if (cDiff < maxDiff) {
                        maxDiff = cDiff;
                        ans = total;
                    }
                    if (total < target) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
}
