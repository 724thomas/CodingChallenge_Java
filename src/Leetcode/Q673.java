package Leetcode;

/*
1. 아이디어 :
Bottom-Up DP를 사용합니다. 2차원 배열에는 [가장 긴 증가하는 길이, 갯수]를 저장합니다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
배열 / DP
 */

public class Q673 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][2]; // maxLength, count
        /*
         1     3     5     4     7
        [4,2] [3,2] [2,1] [2,1] [1,1]
        */

            for (int i=n-1; i>-1; i--) {
                int maxLength = 1, maxCount = 1;
                for (int j=i+1; j<n; j++) {
                    if (nums[i] >= nums[j]) continue;
                    int length = 1+dp[j][0], count = dp[j][1];
                    if (maxLength == length) {
                        maxCount+=count;
                    } else if (maxLength < length) {
                        maxLength = length;
                        maxCount = count;
                    }
                }
                dp[i][0] = maxLength;
                dp[i][1] = maxCount;
                // for (var a : dp) System.out.print(Arrays.toString(a) + " ");
                // System.out.println();
            }

            int ansLength = 0, ansCount = 0;
            for (int i=0; i<n; i++) {
                if (ansLength == dp[i][0]) {
                    ansCount += dp[i][1];
                } else if (ansLength < dp[i][0]) {
                    ansLength = dp[i][0];
                    ansCount = dp[i][1];
                }
            }
            return ansCount;
        }
    }
}
