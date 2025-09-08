package Leetcode.java;

/*
1. 아이디어 :
n이 k로 나눠지지 않으면 false를 리턴

정렬 후, 가장 작은 숫자부터 k개씩 묶어서 카운터 해시맵을 갱신.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.*;

public class Q1296 {
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            int n = nums.length;
            if (n%k != 0) return false;

            Map<Integer, Integer> counter = new HashMap<>();
            List<Integer> distinctNums = new ArrayList<>();
            for (int num : nums) {
                if (!counter.containsKey(num)) {
                    counter.put(num, 1);
                    distinctNums.add(num);
                } else {
                    counter.put(num, counter.get(num)+1);
                }
            }
            Collections.sort(distinctNums);

            for (int num : distinctNums) {
                int count = counter.get(num);
                if (count==0) continue;
                for (int i = num; i<num+k; i++) {
                    counter.put(i, counter.getOrDefault(i, 0)-count);
                    if (counter.get(i) < 0) return false;
                }
            }

            return true;
        }
    }
}
