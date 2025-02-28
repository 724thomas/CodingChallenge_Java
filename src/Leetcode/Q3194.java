package Leetcode;

/*
1. 아이디어 :
정렬 후에 양쪽 끝에서 n/2갯수만큼 순회하면서 최소 평균을 구합니다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
배열 / 정렬
 */

import java.util.Arrays;

public class Q3194 {
    class Solution {
        public double minimumAverage(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            double ans = Integer.MAX_VALUE;
            for (int i=0; i<n/2; i++) ans = Math.min(ans, ((double)nums[i] + nums[n-i-1])/2);

            return ans;

        }
    }
}
