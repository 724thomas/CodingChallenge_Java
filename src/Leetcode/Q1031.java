package Leetcode;

/*
1. 아이디어 :
두개의 prefixSum을 구합니다.
각각의 prefixSum들을 더하면서 최대값을 구합니다.

2. 시간복잡도 :
O( n**2 )

3. 자료구조/알고리즘 :
배열 / 누적합
 */

public class Q1031 {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int ans = 0;
            int n = nums.length;
            int[] fSum = new int[n], sSum = new int[n];

            int total1 = 0, total2 = 0;
            for (int i=0; i<n; i++) {
                total1 += nums[i];
                total2 += nums[i];

                if (i-firstLen >= 0) total1 -= nums[i-firstLen];
                if (i-firstLen >= -1) fSum[i-firstLen+1] = total1;

                if (i-secondLen >= 0) total2 -= nums[i-secondLen];
                if (i-secondLen >= -1) sSum[i-secondLen+1] = total2;
            }

            for (int i=0; i<n; i++) {
                for (int j=i+firstLen; j<n; j++) {
                    ans = Math.max(ans, fSum[i] + sSum[j]);
                }
            }

            for (int i=0; i<n; i++) {
                for (int j=i+secondLen; j<n; j++) {
                    ans = Math.max(ans, sSum[i] + fSum[j]);
                }
            }

            return ans;
        }
    }
}
