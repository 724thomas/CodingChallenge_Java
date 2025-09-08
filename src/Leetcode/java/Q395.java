package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q395 {
    class Solution {
        String s;
        int k, n;

        public boolean check(int size) {
            int[] counter = new int[26];
            int kinds = 0;
            int satisfy = 0;

            for (int i=0; i<size; i++) {
                int idx = s.charAt(i)-'a';
                counter[idx]++;
                if (counter[idx] == 1) kinds++;
                if (counter[idx] == k) satisfy++;
            }
            if (kinds == satisfy) return true;

            for (int i=size; i<n; i++) {
                int left = s.charAt(i-size)-'a';
                counter[left]--;
                if (counter[left] == 0) kinds--;
                if (counter[left] == k-1) satisfy--;

                int right = s.charAt(i) - 'a';
                counter[right]++;
                if (counter[right] == 1) kinds++;
                if (counter[right] == k) satisfy++;

                if (kinds == satisfy) return true;
            }
            return kinds == satisfy;
        }
        public int longestSubstring(String s, int k) {
            this.s=s;
            this.k=k;
            n = s.length();


            int ans = -1;
            for (int i=0; i<=n; i++) {
                if (check(i)) ans = i;
            }
            return ans;
        }
    }
}
