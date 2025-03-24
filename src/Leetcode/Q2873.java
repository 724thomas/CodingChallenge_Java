package Leetcode;

/*
1. 아이디어 :
제약사항이 n<=100이기떄문에 완전탐색으로 풀어도 된다.

2. 시간복잡도 :
O( n**3 )

3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q2873 {
    class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            long ans = 0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) for (int k=j+1; k<n; k++) {
                ans = Math.max(ans, (1L * nums[i] - nums[j]) * nums[k]);
            }
            return ans;
        }
    }
}
