package Leetcode;

/*
1. 아이디어 :
- 브루트포스로 풀 수 있습니다.
- LCM은 integer 범위를 넘어갈 수 있으므로 long 타입을 사용합니다.
- 각 부분 배열의 곱이 GCD와 LCM의 곱과 같은지 확인합니다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

public class Q3411 {
    class Solution {
        int[] nums;

        public long gcd(long a, long b) {
            if (b==0) return a;
            return gcd(b, a%b);
        }
        public long lcm(long a, long b) {
            return a / (int)gcd(a,b) * b;
        }

        public int prodArr(int start, int end) {
            int ans = 1;
            for (int i=start; i<end; i++) ans *= nums[i];
            return ans;
        }

        public int maxLength(int[] nums) {
            int n = nums.length;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                long prod = 1;
                int g = 0;
                long l = 1;

                for (int j = i; j < n; j++) {
                    prod *= nums[j];
                    g = (int)gcd(g, nums[j]);
                    l = lcm(l, nums[j]);

                    if (prod == g * l) ans = Math.max(ans, j - i + 1);
                }
            }

            return ans;
        }
    }
}
