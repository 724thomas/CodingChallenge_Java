package Leetcode.java;

/*
1. 아이디어 :
오른쪽에서 왼쪽으로 순회합니다.
i번째 값이 i+1번째 값보다 크면, i번째 값을 i+1번째 값으로 나누어 떨어지는 가장 큰 약수로 바꿉니다.

2. 시간복잡도 :
O( n * sqrt(m) )

3. 자료구조/알고리즘 :
- / -
 */

public class Q3326 {
    class Solution {
        public int greatest(int num1, int num2) {
            for (int divisor=2; divisor*divisor<=num1; divisor++) { // 10^6
                if (num1%divisor == 0 && divisor <= num2) return divisor;
            }
            return -1;
        }

        public int minOperations(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i=n-2; i>-1; i--) { //10^5
                if (nums[i] <= nums[i+1]) continue;
                int divisor = greatest(nums[i], nums[i+1]);
                if (divisor == -1) return -1;
                nums[i] = divisor;
                ans++;
            }
            return ans;
        }
    }
}
