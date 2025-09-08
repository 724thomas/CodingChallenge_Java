package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3226 {
    class Solution {
        public int minChanges(int n, int k) {
            String bin1 = Integer.toString(n, 2);
            String bin2 = Integer.toString(k, 2);
            int diff = Math.abs(bin1.length() - bin2.length());
            String padd = "0".repeat(diff);

            if (bin1.length() < bin2.length()) {
                bin1 = padd + bin1;
            } else {
                bin2 = padd + bin2;
            }

            int ans = 0;
            for (int i=0; i<bin1.length(); i++) {
                char c1 = bin1.charAt(i), c2 = bin2.charAt(i);
                if (c1!=c2) {
                    if (c1 == '0') return -1;
                    ans++;
                }
            }
            return ans;
        }
    }
}
