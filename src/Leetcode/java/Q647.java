package Leetcode.java;

/*
1. 아이디어 :
index에서 왼쪽, 오른쪽 포인터를 두고 뻗어 나갑니다.

2. 시간복잡도 :
O( 2 * n**2 )

3. 자료구조/알고리즘 :
-
 */

public class Q647 {
    class Solution {
        int ans = 0;
        int n;
        public int countSubstrings(String s) {
            n = s.length();

            for (int i=0; i<n; i++) {
                isPalindrome(s, i, i);
            }

            for (int i=0; i<n-1; i++) {
                isPalindrome(s, i, i+1);
            }
            return ans;
        }

        public void isPalindrome(String s, int left, int right) {
            while (left >= 0 && right <n) {
                if (s.charAt(left) != s.charAt(right)) {
                    return;
                }
                ans++;

                left--;
                right++;
            }

        }
    }
}
