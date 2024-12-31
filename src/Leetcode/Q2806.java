package Leetcode;

public class Q2806 {
    class Solution {
        public int accountBalanceAfterPurchase(int purchaseAmount) {
            return 100 - Math.round((float)purchaseAmount / 10) * 10;
        }
    }
}
