package Leetcode;

/*
1. 아이디어 :
연속된 정수의 합으로 n을 만드는 방법:
정수의 갯수가 1개일때: n = 1m + 0
정수의 갯수가 2개일때: n = 2m + 1
정수의 갯수가 3개일때: n = 3m + 3
정수의 갯수가 4개일때: n = 4m + 6
정수의 갯수가 5개일때: n = 5m + 10
...
정수의 갯수가 k개일때: n = mult * m + curr -> m = (n - curr) / mult
m이 정수이고, mult * m + curr = n이 성립하는 경우들을 찾는다

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q829 {
    class Solution {
        public int consecutiveNumbersSum(int n) {
        /*
        n = 1m + 0
        n = 2m + 1
        n = 3m + 3
        n = 4m + 6
        n = 5m + 10
        ...
        (n - curr) / mult = m

        */
            int ans = 0;
            int curr = 0;
            int mult = 1;

            for (int i=0; i<n; i++) {
                double val = (n - curr) / mult;
                if (val == 0) break;
                if (val == (int)val && (mult*val + curr) == n) ans++;
                curr += mult;
                mult++;
            }

            return ans;
        }
    }
}
