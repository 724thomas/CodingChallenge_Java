package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3750 {
    class Solution {
        public int minimumFlips(int n) {
            String bin = Integer.toBinaryString(n);
            int left = 0, right = bin.length()-1;
            int ans = 0;
            while (left < right) {
                if (bin.charAt(left) != bin.charAt(right)) {
                    ans+=2;
                }
                left++;
                right--;
            }

            return ans;
        }
    }
}
