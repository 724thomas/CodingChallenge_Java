package Leetcode;

/*
1. 아이디어 :
이중 포문으로 모든 조합을 확인

2. 시간복잡도 :
O( n*n)

3. 자료구조/알고리즘 :
- / 브루트 포스
 */

public class Q3184 {
    class Solution {
        public int countCompleteDayPairs(int[] hours) {
            int ans = 0;
            int n = hours.length;

            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                if ((hours[i] + hours[j])%24==0) ans++;
            }
            return ans;
        }
    }
}
