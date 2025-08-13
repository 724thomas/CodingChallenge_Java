package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2913 {
    class Solution {
        public int sumCounts(List<Integer> nums) {
            int n = nums.size(), ans = 0;
            for (int i=0; i<n; i++) {
                Set<Integer> distincts = new HashSet<>();
                for (int j=i; j<n; j++) {
                    distincts.add(nums.get(j));
                    ans += Math.pow(distincts.size(),2);
                }
            }
            return ans;
        }
    }
}
