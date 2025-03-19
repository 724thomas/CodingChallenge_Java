package Leetcode;

/*
1. 아이디어 :
3중 포문을 통해서 모든 경우의 수를 구합니다.

2. 시간복잡도 :
O( n**3 )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

public class Q2928 {
    class Solution {
        public int distributeCandies(int n, int limit) {
            int ans = 0;
            for (int a = 0; a<=limit; a++) for (int b =0; b<=limit; b++) for (int c=0; c<=limit; c++) {
                if (a+b+c == n) ans++;
            }
            return ans;
        }
    }
}
