package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2748 {
    class Solution {
        public int gcd(int a, int b) {
            if (b!=0) return gcd(b, a%b);
            return a;
        }

        public int getFirstDigit(int num) {
            while (num >= 10) num /= 10;
            return num;
        }

        public int getLastDigit(int num) {
            return num % 10;
        }

        public int countBeautifulPairs(int[] nums) {
            int ans = 0;
            int n = nums.length;
            int[][] digits = new int[n][n];
            for (int i=0; i<n; i++) {
                digits[i][0] = getFirstDigit(nums[i]);
                digits[i][1] = getLastDigit(nums[i]);
            }

            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                if (gcd(digits[i][0], digits[j][1]) == 1) ans++;
            }


            return ans;
        }
    }
}
