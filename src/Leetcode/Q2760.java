package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2760 {
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int ans = 0;
            int cmax = 0;
            int prev = -1;
            for (int num: nums) {
                if (prev == -1) {
                    if (num % 2 == 0 && num <= threshold) {
                        cmax = 1;
                        prev = num;
                    }

                } else {
                    if (prev % 2 == num % 2 || num > threshold) {
                        ans = Math.max(ans, cmax);

                        if (num%2 == 0 && num <= threshold) {
                            cmax = 1;
                            prev = num;
                        } else {
                            cmax = 0;
                            prev = -1;
                        }
                    } else {
                        cmax++;
                        prev = num;
                    }
                }
            }

            return Math.max(ans, cmax);
        }
    }
}
