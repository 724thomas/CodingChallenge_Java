package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1558 {
    class Solution {
        public int[] getCount(int num) {
            int[] count = new int[2];
            while (num != 0) {
                if (num%2==0) {
                    num /= 2;
                    count[1]++;
                } else {
                    num -=1;
                    count[0]++;
                }
            }
            return count;
        }

        public int minOperations(int[] nums) {
            int add = 0;
            int mult = 0;
            for (int num : nums) {
                int[] count = getCount(num);
                add+=count[0];
                mult=Math.max(mult, count[1]);
            }
            return add + mult;
        }
    }
}
