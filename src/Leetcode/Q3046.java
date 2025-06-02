package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3046 {
    class Solution {
        public boolean isPossibleToSplit(int[] nums) {
            int[] counter = new int[101];
            for (int num : nums) {
                if (counter[num]++ == 2) return false;
            }
            return true;
        }
    }
}
