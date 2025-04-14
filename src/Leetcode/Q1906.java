package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1906 {
    class Solution {
        public int[] minDifference(int[] nums, int[][] queries) {
            //최대 100가지의 경우
            int n = nums.length, m = queries.length;
            int cmax = 0;
            for (int num : nums) cmax = Math.max(cmax, num);
            int[][] counter = new int[n+1][cmax+1];
            int[] ans = new int[m];

            for (int i=0; i<n; i++) {
                for (int j=0; j<cmax+1; j++) {
                    counter[i+1][j] = counter[i][j];
                }
                counter[i+1][nums[i]]++;
            }

            for (int i=0; i<m; i++) {
                int[] q = queries[i];
                int start = q[0], end = q[1];

                int[] rangeCounter = new int[cmax+1];
                for (int j=0; j<cmax+1; j++) {
                    rangeCounter[j] = counter[end+1][j] - counter[start][j];
                }

                int cmin = Integer.MAX_VALUE;
                int left=-1;
                for (int right=0; right<cmax+1; right++) {
                    if (rangeCounter[right]!=0) {
                        if (left!=-1) {
                            cmin = Math.min(cmin, right-left);
                        }
                        left = right;
                    }
                }

                ans[i] = (cmin == Integer.MAX_VALUE) ? -1 : cmin;
            }

        /*
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0]
[0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0]
[0, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0]
[0, 0, 2, 0, 1, 1, 0, 1, 0, 0, 0]
[0, 0, 2, 0, 1, 1, 0, 1, 0, 0, 1]

[0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]

[0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0]

[0, 0, 2, 0, 1, 1, 0, 1, 0, 0, 1]

[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1]
        */

            return ans;
        }
    }
}
