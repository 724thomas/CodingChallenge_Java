package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q424 {
    class Solution {
        int[] counter;
        public int getK() {
            int cmax = 0;
            int total = 0;
            for (int count : counter) {
                cmax = Math.max(cmax, count);
                total += count;
            }
            return total - cmax;
        }
        public int characterReplacement(String s, int k) {
            int n = s.length();
            counter = new int[26];

            int ans = 0;
            int left = 0;
            for (int right=0; right<n; right++) {
                counter[s.charAt(right)-'A']++;
                while (getK() > k) {
                    counter[s.charAt(left++)-'A']--;
                }
                ans = Math.max(ans, right-left);
            }
            return ans+1;
        }
    }
}
