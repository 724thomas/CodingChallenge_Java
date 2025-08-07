package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1317 {
    class Solution {
        public boolean check(int n) {
            while (n>1) {
                int remain = n%10;
                if (remain == 0) return false;
                n = n/10;
            }
            return true;
        }
        public int[] getNoZeroIntegers(int n) {
            int a = n-1, b = 1;
            while (!check(a) || !check(b)) {
                a--;
                b++;
            }
            return new int[]{a, b};
        }
    }
}
