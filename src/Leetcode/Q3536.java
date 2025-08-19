package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3536 {
    class Solution {
        public int maxProduct(int n) {
            String num = String.valueOf(n);
            int ans = 0;
            for (int i=0; i<num.length(); i++) {
                for (int j=i+1; j<num.length(); j++) {
                    ans = Math.max(ans, (num.charAt(i)-'0') * (num.charAt(j)-'0'));
                }
            }
            return ans;
        }
    }
}
