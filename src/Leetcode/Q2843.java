package Leetcode;

/*
1. 아이디어 :
- 대칭인지 확인하는 메서드 isSymmetrical을 구현한다.
    - 숫자 길이의 반 만큼 오른쪽과 왼쪽의 합을 구한다.
- low부터 high까지 반복하면서, 숫자의 길이가 짝수인 경우에만 isSymmetrical을 호출한다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
- / -
 */

public class Q2843 {
    class Solution {
        public int isSymmetrical(int num) {
            int length = String.valueOf(num).length();
            int right = 0;
            for (int i=0; i<length/2; i++) {
                right += num % 10;
                num /= 10;
            }

            int left = 0;
            for (int i=0; i<length/2; i++) {
                left += num % 10;
                num /= 10;
            }
            return (left == right)? 1:0;
        }
        public int countSymmetricIntegers(int low, int high) {
            int ans = 0;
            for (int num = low; num <= high; num++) {
                if (String.valueOf(num).length() % 2 != 0) continue;
                ans += isSymmetrical(num);
            }
            return ans;
        }
    }
}
