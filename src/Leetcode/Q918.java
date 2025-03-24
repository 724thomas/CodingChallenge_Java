package Leetcode;

/*
1. 아이디어 :
- 비원형일때의 최대값 또는 원형일때의 최대값을 구하면 된다.
- 비원형일때의 최대값은 dp를 이용하여 구하고, 원형일때의 최대값은 전체합에서 최소값을 빼주면 된다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / dp
 */

public class Q918 {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int[] dpMax = new int[n];
            int[] dpMin = new int[n];
            dpMax[0] = nums[0]; // i번째까지 최대값
            dpMin[0] = nums[0]; // i번째까지 최소값
            int cmax = nums[0];
            int cmin = nums[0];

            int total = nums[0];

            for (int i=1; i<n; i++) {
                dpMax[i] = Math.max(dpMax[i-1]+nums[i], nums[i]);
                cmax = Math.max(cmax, dpMax[i]);

                dpMin[i] = Math.min(dpMin[i-1]+nums[i], nums[i]);
                cmin = Math.min(cmin, dpMin[i]);

                total += nums[i];
            }
            // System.out.println(Arrays.toString(dpMax));
            // System.out.println(Arrays.toString(dpMin));

            if (cmax < 0) return cmax;

            //최대값 또는 전체-최소값
            return Math.max(cmax, total - cmin);
        }
    }
}
