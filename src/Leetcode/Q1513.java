package Leetcode;

/*
1. 아이디어 :
연속되는 1의 길이를 찾을 떄마다 count의 결과값을 더해줍니다
count 메서드는 연속된 1의 길이 사이에 몇개의 조합이 있는지 셉니다.

2. 시간복잡도 :
O( n * n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q1513 {
    class Solution {
        int MOD = 1_000_000_007;

        public int count(int length) {
            int total = 0;
            for (int i=1; i<=length; i++) {
                total = (total + length - i + 1) % MOD;
            }
            return total;
        }

        public int numSub(String s) {
            int ans = 0, length = 0;

            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != '1') {
                    ans += count(length);
                    length = 0;
                } else {
                    length ++;
                }
            }
            ans += count(length);
            return ans;
        }
    }
}
