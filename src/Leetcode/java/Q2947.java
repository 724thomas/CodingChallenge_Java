package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2947 {
    class Solution {
        public int beautifulSubstrings(String s, int k) {
            int n = s.length();
            int ans = 0;
            for (int i=0; i<n; i++) {
                int count1 = 0, count2 = 0;  // vowels, consonants
                for (int j=i; j<n; j++) {
                    char c = s.charAt(j);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        count1++;
                    } else {
                        count2++;
                    }
                    if (Integer.compare(count1, count2)==0
                            && count1 * count2 % k == 0) ans++;
                }
            }
            return ans;
        }
    }
}
