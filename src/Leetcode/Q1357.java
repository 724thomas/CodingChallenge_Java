package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
Cashier = O( n )
getBill = O( m )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.HashMap;
import java.util.Map;

public class Q1357 {
    class Cashier {
        int n;
        int count = 0;
        int discount;
        Map<Integer, Integer> productCostMap = new HashMap<>();
        int[] productCost;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            productCost = new int[201];

            for (int i=0; i<products.length; i++) {
                productCost[products[i]] = prices[i];
            }
        }

        public double getBill(int[] product, int[] amount) {
            double total = 0;
            for (int i=0; i<product.length; i++) {
                total += amount[i] * productCost[product[i]];
            }
            return (++count % n == 0) ? total * ((100-discount)) / 100 : total;
        }
    }

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
}
