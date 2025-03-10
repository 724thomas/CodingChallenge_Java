package Leetcode;

/*
1. 아이디어 :
- 그리디하게 풀 수 있다.
- 모든 0은 항상 포함되어야 한다.
- s의 오른쪽부터 1을 포함시키면서 k를 넘는지 확인한다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / 그리디
 */

public class Q2311 {
    class Solution {
        public int longestSubsequence(String s, int k) {
            int n = s.length(), ans = 0;
            long curr = 1, total = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') ans++;
            }

            for (int i = 0; i < n; i++) {
                if (s.charAt(n-i-1) == '1') {
                    if (total + curr > k) break;
                    total += curr;
                    ans++;
                }

                if (curr > k) break;
                curr *= 2;
            }

            return ans;
        }
    }


}
