package Leetcode.java;

/*
1. 아이디어 :
방문처리와, 최대값을 유지

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.HashSet;
import java.util.Set;

public class Q3487 {
    class Solution {
        public int maxSum(int[] nums) {
            Set<Integer> visited = new HashSet<>();
            int ans = 0;
            int cmax = Integer.MIN_VALUE;
            for (int num : nums) {
                if (!visited.contains(num) && num > 0) ans+=num;
                visited.add(num);
                cmax = Math.max(cmax, num);
            }
            return ans == 0? cmax : ans;
        }
    }
}
