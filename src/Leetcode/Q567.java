package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q567 {
    class Solution {
        int[] baseCount;
        int[] count;
        public boolean check() {
            for (int i=0; i<26; i++) {
                if (baseCount[i] != count[i]) return false;
            }
            return true;
        }
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (m < n) return false;

            baseCount = new int[26];
            for (char c : s1.toCharArray()) baseCount[c-'a']++;

            count = new int[26];
            for (int i=0; i<n; i++) {
                count[s2.charAt(i)-'a']++;
            }
            if (check()) return true;

            for (int i=0; i<m-n; i++) {
                count[s2.charAt(i)-'a']--;
                count[s2.charAt(i+n)-'a']++;
                if (check()) return true;
            }
            return false;
        }
    }
}
