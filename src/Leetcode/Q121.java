package Leetcode;

/*
1. 아이디어 :
price를 순회하면서
- 현재 최소값보다 더 작은 값을 만나면, 현재 최대값-최소값을 정답으로 갱신 후 최소값도 갱신하고 최대값은 초기화합니다.
- 현재 최소값보다 더 작은 값이 아니면, 현대 최대값을 갱신합니다.


2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / memoization
 */

public class Q121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0, cmin = Integer.MAX_VALUE, cmax = 0;
            for (int price : prices) {
                cmax = (price < cmin)? 0: Math.max(cmax, price);
                if (price < cmin) cmin = price;
                ans = Math.max(ans, cmax - cmin);
            }
            return ans;
        }
    }
}
