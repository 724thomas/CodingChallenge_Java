package Leetcode;

/*
1. 아이디어 :
curr : 현재까지의 만족도
total에 누적된 curr의 합을 저장하고, ㅁns를 갱신

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.Arrays;

public class Q1402 {
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int n = satisfaction.length;
            int curr = 0, total = 0, ans = 0;
            for (int i=n-1; i>-1; i--) {
                curr += satisfaction[i];
                total += curr;
                ans = Math.max(ans, total);
            }
            return ans;
        }
    }
}
