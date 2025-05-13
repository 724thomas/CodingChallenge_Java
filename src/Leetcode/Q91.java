package Leetcode;

/*
1. 아이디어 :
dp 문제
- dp[i] : i번째부터의 경우의 수 (dp[n] = 1)
i번째 캐릭터가:
- 0일 경우, 만들어질 수 없음
- 1~9일 경우, 만들어질 수 있고, idx+1을 계산
- 10~26일 경우, 만들어질 수 있고, idx+2를 추가로 계산

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- dp / 재귀
 */

public class Q91 {
    class Solution {
        int n;
        Integer[] dp; //i번째까지의 경우의 수
        String s;

        public int helper(int idx) {
            if (dp[idx] != null) return dp[idx];

            if (s.charAt(idx) == '0') return 0;

            int total = helper(idx+1);

            if (idx+1 < n) {
                if (s.charAt(idx) == '1' ||
                        (s.charAt(idx) == '2' && Integer.parseInt(s.charAt(idx+1)+"") <=6) ) {
                    total += helper(idx+2);
                }
            }

            dp[idx] = total;
            return total;
        }

        public int numDecodings(String s) {
            this.s=s;
            n=s.length();
            dp = new Integer[n+1];
            dp[n] = 1;

            return helper(0);
        }
    }
}
