package Leetcode;

/*
1. 아이디어 :
차이를 계산하는 diff를 구합니다.
규칙:
0부터 시작해서 커질때마다 diff-prev를 더합니다. 또는, 0부터 시작해서 작아질떄마다 prev-diff를 더합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q3229 {
    class Solution {
        public long minimumOperations(int[] nums, int[] target) {
            int n = nums.length;
            long ans = 0;
            int prev = 0;
            for (int i=0; i<n; i++) {
                int diff = target[i] - nums[i];
                if (prev < diff) ans += diff-prev;
                prev = diff;
            }
            if (prev < 0) ans += -prev;
            return ans;

        /*
        [3,8,5,4,1,7]
        [2,7,4,3] [6] 1
        [2.7.4.3] = 1+6
        [5,2,1] = 2+1+6
        [4,1] = 2+1+1+6
        [3] = 2+1+1+1+6
        [] = 2+3+1+1+1+6 = 14
        3+5+0+0+0+6+0=14
        0+0+3+1+3+0+7=14

        [3,8,-5,-4,1,7]
        [3,8][-5,-4][1,7]
        [5][-1][6] = 3+4+1
        [] = 3+5+1+4+1+6=20
        3+5+0+1+5+6+0=20
        0+0+13+0+0+0+7=20


        */
        }
    }
}
