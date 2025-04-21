package Leetcode;

/*
1. 아이디어 :
브루트포스로 풀 수 있습니다

2. 시간복잡도 :
O( n*n )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

import java.util.List;

public class Q3364 {
    class Solution {
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            int n = nums.size();
            int ans = Integer.MAX_VALUE;
            for (int i=0; i<n; i++) {
                int total = 0;
                for (int j=i; j<Math.min(n, i+r); j++) {
                    total += nums.get(j);
                    if (l <= j-i+1 && j-i+1 <= r && total >0) ans = Math.min(ans, total);
                }
            }

            return ans == Integer.MAX_VALUE? -1: ans;
        }
    }
}
