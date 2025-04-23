package Leetcode;

/*
1. 아이디어 :
순차적으로 순회를 하면서 0을 만나면 연속된 3개를 뒤집는다

2. 시간복잡도 :
O( 3n )

3. 자료구조/알고리즘 :
- / 브루트 포스
 */

public class Q3191 {
    class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            int n = nums.length;
            for (int i=0; i<n-2; i++) {
                if (nums[i] == 0) {
                    for (int j=i; j<i+3; j++) nums[j] = (nums[j]+1)%2;
                    ans++;
                }
            }
            return (nums[n-2] == 0 || nums[n-1] == 0)? -1:ans;
        }
    }
}
