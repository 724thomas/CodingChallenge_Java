package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3232 {
    class Solution {
        public boolean canAliceWin(int[] nums) {
            int sNum = 0, total = 0;
            for (int num : nums) {
                if (num <10) sNum+=num;
                total += num;
            }
            return total - sNum != sNum;
        }
    }
}
