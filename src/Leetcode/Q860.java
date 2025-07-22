package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] counter = new int[3];

            for (int bill : bills) {
                if (bill == 20) {
                    if (counter[1] >= 1 && counter[0] >= 1) {
                        counter[0]--;
                        counter[1]--;
                    } else if (counter[0] >= 3) {
                        counter[0]-=3;
                    } else {
                        return false;
                    }
                } else if (bill == 10) {
                    if (counter[0] >= 1) {
                        counter[0]--;
                        counter[1]++;
                    } else {
                        return false;
                    }
                } else {
                    counter[0]++;
                }
            }
            return true;
        }
    }
}
