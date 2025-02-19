package Leetcode;

/*
1. 아이디어 :
2중 포문을 돌면서 확인합니다.

2. 시간복잡도 :
O( n**2 )

3. 자료구조/알고리즘 :
배열 / -
 */

public class Q2765 {
    class Solution {
        public int alternatingSubarray(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i=0; i<n; i++) {
                int prev = nums[i];
                int diff = 1;
                int size = 1;

                for (int j=i+1; j<n; j++) {
                    int curr = nums[j];
                    if (prev + diff == curr) {
                        size ++;
                        diff *= -1;
                        ans = Math.max(ans, size);
                        prev = curr;
                    } else {
                        break;
                    }
                }
            }

            return (ans < 2) ? -1 : ans;
        }
    }
}
