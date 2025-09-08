package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3190 {
    class Solution {
        public int makeDivisible(int num) {
            num = num%3;
            return Math.min(3-num, num);
        }
        public int minimumOperations(int[] nums) {
            int ans = 0;
            for (int num : nums) ans += makeDivisible(num);
            return ans;
        }
    }
}
