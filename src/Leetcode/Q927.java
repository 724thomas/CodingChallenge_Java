package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q927 {
    class Solution {
        public int[] threeEqualParts(int[] nums) {
            int n = nums.length;
            int[] ans = new int[]{-1,-1};
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for (int i=1; i<n; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }

            int total1 = prefixSum[n-1];
            if (total1 % 3 != 0) return ans;
            if (total1 == 0) return new int[]{0, 2};
            int parts1 = total1/3;

            int first = -1, second = -1, third = -1;
            int count = 0;


            //leading zero를 제외한 1이 시작되는 곳.
            for (int i=0; i<n; i++) {
                if (nums[i] == 1) {
                    count++;
                    if (count == 1) {
                        first = i;
                    } else if (count == parts1 + 1) {
                        second = i;
                    } else  if (count == 2 * parts1 + 1) {
                        third = i;
                    }
                }
            }
            // System.out.println(first + " " + second + " " + third);

            while (third < n) {
                if (nums[first] != nums[second] || nums[second] != nums[third]) {
                    return ans;
                }
                first++;
                second++;
                third++;
            }
            // System.out.println(first + " " + second + " " + third);

            return new int[]{first-1, second};
        }
    }
}
