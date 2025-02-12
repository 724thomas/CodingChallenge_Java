package Leetcode;

/*
1. 아이디어 :
슬라이딩 윈도우로 풀 수 있습니다.
윈도우 사이즈만큼 순회합니다.
diff1 = i가 짝수이고 1일때 || i가 홀수이고 0일때, 1씩 추가합니다.
diff2 = i가 짝수이고 0일때 || i가 홀수이고 1일때, 1씩 추가합니다.

s만큼 순회를 하면서,
- lchar는 왼쪽, rchar는 오른쪽 char를 가져옵니다.
- diff1과 diff2의 추가, 차감 로직은 동일합니다.


2. 시간복잡도 :
O( 2n )

3. 자료구조/알고리즘 :
문자열 / 슬라이딩 윈도우
 */

public class Q1888 {
    class Solution {
        public int minFlips(String s) {
            int n = s.length(), diff1=0, diff2=0;
            s = s+s;

            for (int right=0; right<n; right++) {
                char rchar = s.charAt(right);
                if ((right % 2 == 0 && rchar != '0') || (right % 2 != 0 && rchar != '1')) {
                    diff1++;
                }

                if ((right % 2 == 0 && rchar != '1') || (right % 2 != 0 && rchar != '0')) {
                    diff2++;
                }
            }

            int ans = Math.min(diff1, diff2);

            for (int left = 0; left<n; left++) {
                int right = left + n;
                char lchar = s.charAt(left), rchar = s.charAt(left+n);
                if ((right % 2 == 0 && rchar != '0') || (right % 2 != 0 && rchar != '1')) {
                    diff1++;
                }

                if ((right % 2 == 0 && rchar != '1') || (right % 2 != 0 && rchar != '0')) {
                    diff2++;
                }

                if ((left % 2 == 0 && lchar != '0') || (left % 2 != 0 && lchar != '1')) {
                    diff1--;
                }

                if ((left % 2 == 0 && lchar != '1') || (left % 2 != 0 && lchar != '0')) {
                    diff2--;
                }
                ans = Math.min(ans, Math.min(diff1, diff2));
            }

            return ans;
        }
    }
}
