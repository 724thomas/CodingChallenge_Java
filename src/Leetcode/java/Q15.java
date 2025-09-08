package Leetcode.java;

/*
1. 아이디어 :
정렬 후, 왼쪽, 중간, 오른쪽 포인터를 둔다.
왼쪽은 0부터 순회하고,
중간, 오른쪽은 이분탐색을 수행한다.
포인터를 옮기게 되면, 중복된 숫자는 건너뛴다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / 이분탐새
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int left = 0; left<n; left++) {
                int lv = nums[left];
                int mid = left+1, right = n-1;
                while (mid < right) {
                    int mv = nums[mid], rv = nums[right];
                    if (lv + mv + rv == 0) {
                        ans.add(List.of(lv, mv, rv));
                        while (mid+1 < n && nums[mid] == nums[mid+1]) mid++;
                        while (right-1 >= 0 && nums[right] == nums[right-1]) right--;
                        mid++;
                        right--;
                    } else if (lv+mv+rv < 0) {
                        while (mid+1 < n && nums[mid] == nums[mid+1]) mid++;
                        mid++;
                    } else if (lv+mv+rv > 0) {
                        while (right-1 >= 0 && nums[right] == nums[right-1]) right--;
                        right--;
                    }
                }
                while (left+1 < n && nums[left] == nums[left+1]) left++;
            }
            return ans;
        }
    }
}
