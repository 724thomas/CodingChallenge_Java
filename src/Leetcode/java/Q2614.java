package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2614 {
    class Solution {
        private boolean isPrime(int n) {
            if (n==1) return false;
            if (n<=3) return true;
            for (int i=2; i<=Math.sqrt(n); i++) {
                if (n%i==0) return false;
            }
            return true;
        }
        public int diagonalPrime(int[][] nums) {
            int n = nums.length;
            int ans = 0;

            for (int i=0; i<n; i++) {
                if (isPrime(nums[i][i])) ans = Math.max(ans, nums[i][i]);
                if (isPrime(nums[i][n-i-1])) ans = Math.max(ans, nums[i][n-i-1]);
            }
            return ans;
        }
    }
}
