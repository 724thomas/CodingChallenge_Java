package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q696 {
    class Solution {
        String s;
        int n;

        public int count(int idx) {
            int num = s.charAt(idx);
            int left = idx, right = idx+1;
            int total = 0;
            while (left>=0 && right<n && s.charAt(left) == num && s.charAt(right) != num) {
                total++;
                left--;
                right++;
            }
            return total;
        }

        public int countBinarySubstrings(String s) {
            this.s = s;
            n = s.length();
            int ans = 0;
            for (int i=0; i<n-1; i++) {
                if (s.charAt(i) != s.charAt(i+1)) {
                    ans += count(i);
                }
            }
            return ans;
        }
    }
}
