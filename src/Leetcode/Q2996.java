package Leetcode;

/*
1. 아이디어 :
0번째 인덱스부터 연속된 숫자들까지 합을 구합니다.
num를 해시셋으로 변환 후, total이 해시셋에 없을 때까지 증가시킵니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시셋 / 부르트포스
 */

import java.util.HashSet;
import java.util.Set;

public class Q2996 {
    class Solution {
        public int missingInteger(int[] nums) {
            int n = nums.length;
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) numSet.add(num);

            int total = nums[0];
            for (int i=1; i<n; i++) {
                if (nums[i-1]+1 != nums[i]) break;
                total += nums[i];
            }
            while (numSet.contains(total)) total++;
            return total;
        }
    }
}
