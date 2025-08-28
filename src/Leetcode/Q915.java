package Leetcode;

/*
1. 아이디어 :
누적합을 통해 왼쪽 최대값, 오른쪽 최소값을 각각 저장
왼쪽최대[i] <= 오른쪽최소[i+1]일때 i+1 리턴

2. 시간복잡도 :
O( 2n )

3. 자료구조/알고리즘 :
배열 / 누적합
 */

public class Q915 {
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[n], rightMin = new int[n];
            leftMax[0] = nums[0];
            rightMin[n-1] = nums[n-1];

            for (int i=1; i<n; i++) {
                leftMax[i] = Math.max(leftMax[i-1], nums[i]);
                rightMin[n-1-i] = Math.min(rightMin[n-i], nums[n-1-i]);
            }

            for (int i=0; i<n-1; i++) {
                if (leftMax[i] <= rightMin[i+1]) return i+1;
            }
            return -1;
        }
    }
}
