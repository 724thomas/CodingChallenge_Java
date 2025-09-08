package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.List;

public class Q2824 {
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            int ans = 0, n = nums.size();
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    if (nums.get(i) + nums.get(j) < target) ans++;
                }
            }

            return ans;
        }
    }
}
