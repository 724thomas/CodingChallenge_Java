package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1979 {
    class Solution {
        public int gcd(int a, int b) {
            if (b==0) return a;
            return gcd(b, a%b);
        }
        public int findGCD(int[] nums) {
            int cmin = Integer.MAX_VALUE, cmax = -Integer.MAX_VALUE;
            for (int num : nums) {
                cmin = Math.min(cmin, num);
                cmax = Math.max(cmax, num);
            }
            return gcd(cmin,cmax);
        }
    }
}
