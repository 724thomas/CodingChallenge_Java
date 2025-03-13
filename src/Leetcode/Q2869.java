package Leetcode;

/*
1. 아이디어 :
해시셋을 통해 중복처리를 합니다
k보다 작은 숫자들만 해시셋에 저장하고, 해시셋의 크기가 k가 되면 그때의 i+1를 반환합니다

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시셋 / -
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2869 {
    class Solution {
        public int minOperations(List<Integer> nums, int k) {
            int n = nums.size();
            Set<Integer> visited = new HashSet<>();
            for (int i=0; i<n; i++) {
                int num = nums.get(n-i-1);
                if (num <= k) visited.add(num);
                if (visited.size() == k) return i+1;
            }
            return -1;
        }
    }
}
