package Leetcode;

/*
1. 아이디어 :
그리디하게 풀 수 있습니다.
큰 값부터 정렬 후에, 누적합을 구하면서 0보다 작아지면 break합니다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / 누적합
 */

import java.util.Arrays;

public class Q2587 {
    class Solution {
        public int maxScore(int[] nums) {
            Arrays.sort(nums);
            long curr = 0L;
            int ans = 0;
            for (int i=nums.length-1; i>-1; i--) {
                curr += nums[i];
                if (curr <= 0) break;
                ans++;
            }
            return ans;
        }
    }
}
