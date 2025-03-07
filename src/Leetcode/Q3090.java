package Leetcode;

/*
1. 아이디어 :
투 포인터로 풀 수 있습니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / 투포인터
 */

public class Q3090 {
    class Solution {
        public int maximumLengthSubstring(String s) {
            int[] counter = new int[26];
            int n = s.length(), ans = 0, left = 0;
            for (int right = 0; right<n; right++) {
                char c = s.charAt(right);
                while (counter[c-'a'] >= 2) counter[s.charAt(left++)-'a']--;
                counter[c-'a'] ++;
                ans = Math.max(ans, right-left+1);
            }
            return ans;
        }
    }
}
