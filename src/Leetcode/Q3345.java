package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3345 {
    class Solution {
        public int productDigit(int n) {
            int ans = 1;
            for (char c : String.valueOf(n).toCharArray()) {
                ans *= Integer.parseInt(c+"");
            }
            return ans;
        }
        public int smallestNumber(int n, int t) {
            int ans = n;
            while (ans < n || productDigit(ans) % t != 0) ans += 1;
            return ans;
        }
    }
}
