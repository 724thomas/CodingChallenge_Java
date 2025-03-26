package Leetcode;

/*
1. 아이디어 :
구현

2. 시간복잡도 :
O( n * n * m) : n은 words의 길이, m은 words의 길이

3. 자료구조/알고리즘 :
- / -
 */

public class Q3042 {
    class Solution {
        public int isPrefixAndSuffix(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) return 0;
            for (int i=0; i<n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) return 0;
                if (s1.charAt(n-1-i) != s2.charAt(m-1-i)) return 0;
            }
            return 1;
        }
        public int countPrefixSuffixPairs(String[] words) {
            int n = words.length, ans =0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                ans += isPrefixAndSuffix(words[i], words[j]);
            }
            return ans;
        }
    }
}
