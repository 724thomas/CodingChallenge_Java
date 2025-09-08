package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.List;

public class Q3350 {
    class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int n = nums.size();
            int ans = 0;

            int plength = 0, clength = 1;

            for (int i=1; i<n; i++) {
                int prev = nums.get(i-1), curr = nums.get(i);

                if (prev < curr) {
                    clength++;
                } else {
                    ans = Math.max(ans, clength/2);
                    ans = Math.max(ans, Math.min(plength, clength));

                    plength = clength;
                    clength = 1;
                }
            }
            ans = Math.max(ans, clength/2);
            ans = Math.max(ans, Math.min(plength, clength));

            return ans;
        }
    }
}
