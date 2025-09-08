package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3028 {
    class Solution {
        public int returnToBoundaryCount(int[] nums) {
            int curr = 0, ans = 0;
            for (int num : nums) {
                curr += num;
                if (curr == 0) ans++;
            }
            return ans;
        }
    }
}
