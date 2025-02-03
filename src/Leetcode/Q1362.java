package Leetcode;

public class Q1362 {
    class Solution {
        public int[] closestDivisors(int num) {
            int num1 = num+1;
            int[] candid1 = new int[2];
            for (int i= (int)Math.sqrt(num1); i>0; i--) {
                if (num1 % i == 0) {
                    candid1 = new int[]{i, num1/i};
                    break;
                }
            }

            int num2 = num+2;
            int[] candid2 = new int[2];
            for (int i= (int)Math.sqrt(num2); i>0; i--) {
                if (num2 % i == 0) {
                    candid2 = new int[]{i, num2/i};
                    break;
                }
            }

            return (candid1[1] - candid1[0] <= candid2[1] - candid2[0]) ? candid1 : candid2;
        }
    }
}
